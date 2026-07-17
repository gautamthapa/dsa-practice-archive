# Designing Paytm-like Payment Service 💳

Real-world system design question focusing on scalable payment platform.

---

## Requirements

### Functional Requirements
1. **User Management**
    - User registration and authentication
    - KYC (Know Your Customer) verification
    - Profile management

2. **Wallet Management**
    - Add money to wallet (via card, bank transfer)
    - Check wallet balance
    - Transaction history

3. **Payment Processing**
    - Transfer money to another user
    - Pay merchant (recharge, bills, shopping)
    - Request money from others

4. **Notifications**
    - SMS/Email confirmations
    - Transaction alerts
    - Fraud notifications

### Non-Functional Requirements
1. **Performance**: < 100ms response time
2. **Availability**: 99.99% uptime (4 nines)
3. **Scalability**: Handle 10M+ daily transactions
4. **Consistency**: Strong consistency for wallet balance
5. **Security**: Encrypted data, PCI-DSS compliance
6. **Reliability**: No money loss, idempotent operations

---

## Architecture Design

### High-Level Architecture
```
┌─────────────────────────────────────────────────────────────┐
│                    CDN (Images, Static)                     │
└─────────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────────┐
│                   API Gateway (Nginx)                       │
│  - Load balancing                                           │
│  - Rate limiting (prevent DDoS)                             │
│  - Request validation                                       │
└─────────────────────────────────────────────────────────────┘
                            ↓
     ┌──────────────────────┼──────────────────────┐
     ↓                      ↓                      ↓
┌──────────────┐  ┌──────────────┐  ┌──────────────┐
│  User Service│  │Wallet Service│  │Payment Service
│  (3 inst)    │  │  (5 inst)    │  │  (4 inst)    │
│              │  │              │  │              │
│ PostgreSQL   │  │ Redis Cache  │  │ PostgreSQL   │
│ MySQL        │  │ PostgreSQL   │  │ + Redis      │
└──────────────┘  └──────────────┘  └──────────────┘
                            │
                    ┌───────┴───────┐
                    ↓               ↓
            ┌─────────────────┐  ┌─────────────────┐
            │ Kafka (Events)  │  │ Elasticsearch   │
            │                 │  │ (Search/Logs)   │
            └─────────────────┘  └─────────────────┘
                    ↓
            ┌─────────────────┐
            │ Analytics       │
            │ (InfluxDB)      │
            └─────────────────┘
```

---

## Service Architecture

### 1. User Service
**Responsibility**: User authentication and profile management

```
Features:
- Registration (email, phone, password)
- KYC verification (Aadhar, PAN verification)
- Login/Logout (JWT tokens)
- Profile updates

Database:
- MySQL: User data, KYC info (strong consistency needed)
- Redis: Session cache

API Endpoints:
- POST /users/register
- POST /users/kyc-verify
- POST /users/login
- GET /users/{id}
- PUT /users/{id}
```

### 2. Wallet Service
**Responsibility**: Balance management and fund transfers

```
Features:
- Add money (debit card, net banking)
- Check balance
- Money transfer to other user
- Transaction history

Database:
- PostgreSQL: Wallet balance (strong consistency - ACID!)
- Redis: Cache balance for fast reads
- MongoDB: Transaction history

Key Decision: STRONG CONSISTENCY
Reason: Can't afford inconsistent balance (money loss!)

Strategies:
- Distributed locks (Redis/Zookeeper) for concurrent transfers
- ACID transactions for balance updates
- Idempotent operations (retry-safe)

API Endpoints:
- POST /wallet/add-money
- GET /wallet/balance
- POST /wallet/transfer
- GET /wallet/transactions
```

### 3. Payment Service
**Responsibility**: Payment processing and order management

```
Features:
- Process merchant payments (recharge, bills)
- Money requests
- Split bills
- Subscription payments

Database:
- MongoDB: Payment orders (flexible schema)
- PostgreSQL: Settlement records
- Cassandra: Payment events (time-series)

Circuit Breaker:
- Payment Gateway API calls (external)
- Fallback: Queue for later processing

Event-Driven:
- Publish payment events to Kafka
- Other services consume and react

API Endpoints:
- POST /payments/initiate
- GET /payments/{id}
- POST /payments/{id}/confirm
- POST /payments/requests
```

### 4. Notification Service
**Responsibility**: SMS, Email, Push notifications

```
Features:
- SMS notifications (Twilio, Nexmo)
- Email notifications (SendGrid)
- In-app notifications
- Push notifications

Async Processing:
- Consume events from Kafka
- Queue async jobs
- Retry on failure

Don't Block Main Transaction:
- Payment succeeds → Send notification (fire & forget)
- If notification fails, doesn't affect payment
```

### 5. Merchant Service
**Responsibility**: Merchant onboarding and management

```
Features:
- Merchant registration
- Settlement reporting
- Merchant dashboard
- Bulk payment processing

Database:
- MongoDB: Merchant profiles
- PostgreSQL: Settlement records

APIs needed by payment service:
- GET /merchants/{id}
- POST /merchants/{id}/settle
```

---

## Database Design

### User Service (PostgreSQL - ACID needed)
```sql
Table: users
├─ user_id (PK)
├─ email (UNIQUE)
├─ phone (UNIQUE)
├─ password_hash
├─ kyc_status (PENDING, VERIFIED, REJECTED)
├─ created_at
└─ updated_at

Table: kyc_documents
├─ kyc_id (PK)
├─ user_id (FK)
├─ doc_type (AADHAR, PAN, PASSPORT)
├─ doc_number
├─ verification_status
└─ verified_at

Indexes:
- email (fast login)
- phone (fast lookup)
- kyc_status (find unverified users)
```

### Wallet Service (PostgreSQL - STRONG CONSISTENCY)
```sql
Table: wallets
├─ wallet_id (PK)
├─ user_id (FK, UNIQUE)
├─ balance (DECIMAL 15,2)
├─ currency (USD, INR)
├─ version (for optimistic locking)
├─ created_at
└─ updated_at

Table: transactions
├─ txn_id (PK)
├─ from_wallet_id (FK)
├─ to_wallet_id (FK)
├─ amount (DECIMAL 15,2)
├─ status (PENDING, SUCCESS, FAILED)
├─ idempotency_key (UNIQUE - prevent duplicates)
├─ created_at
└─ updated_at

Indexes:
- user_id (get user's wallet)
- from_wallet_id, to_wallet_id (transaction history)
- idempotency_key (prevent duplicate charges)

Constraints:
- balance >= 0 (can't go negative)
- Foreign keys for data integrity
```

### Payment Orders (MongoDB - Flexible schema)
```javascript
// Collection: payment_orders
{
  _id: ObjectId(),
  order_id: "ORD-123456",
  user_id: "USER-789",
  merchant_id: "MERCHANT-456",
  amount: 5000,
  status: "COMPLETED",  // PENDING, PROCESSING, COMPLETED, FAILED
  payment_method: "WALLET",
  
  // Order details (flexible structure)
  items: [
    {
      item_id: "ITEM-1",
      name: "Electricity Bill",
      quantity: 1,
      price: 5000
    }
  ],
  
  // Timestamps
  created_at: ISODate("2024-01-15T10:30:00Z"),
  processed_at: ISODate("2024-01-15T10:30:05Z"),
  
  // Metadata
  device_info: {...},
  ip_address: "192.168.1.1",
  
  // Tracking
  idempotency_key: "key-123",
  correlation_id: "corr-456"
}
```

---

## Data Flow: Money Transfer Example

### Scenario: User A transfers ₹100 to User B

```
1. User A initiates transfer
   └─ POST /wallet/transfer
   
2. API Gateway receives request
   └─ Rate limit check
   └─ Input validation
   
3. Payment Service processes
   ├─ Check User A balance (Redis cache)
   ├─ Start transaction (PostgreSQL)
   │  ├─ Debit A's wallet: ₹100
   │  ├─ Credit B's wallet: ₹100
   │  └─ Commit transaction (ACID)
   ├─ Invalidate Redis cache
   ├─ Log transaction to MongoDB
   ├─ Publish event to Kafka
   └─ Return success response (< 100ms)
   
4. Notification Service (async)
   ├─ Consume event from Kafka
   ├─ Send SMS to A: "Transferred ₹100 to B"
   ├─ Send SMS to B: "Received ₹100 from A"
   └─ Update in-app notifications
   
5. Analytics Service (async)
   └─ Consume event from Kafka
   └─ Update transaction metrics
   
6. Reconciliation (daily)
   └─ Verify all transfers match wallet balances
   └─ Alert on discrepancies
```

---

## Handling Failures

### Scenario: Payment gateway fails during charge

```
User charges ₹5000 via credit card

1. Wallet Service creates pending transaction
   ├─ Save to DB with status: PENDING
   └─ Return txn_id to user
   
2. Call external payment gateway
   ├─ Circuit breaker activated
   ├─ If fails: Mark txn as PENDING (will retry)
   ├─ If timeout: Mark txn as PENDING
   └─ Return to user: "Processing, we'll notify you"
   
3. Retry mechanism
   └─ Background job retries every 5 minutes
   └─ Maximum 3 retries over 15 minutes
   
4. After retry succeeds
   ├─ Mark transaction as SUCCESS
   ├─ Add money to wallet
   ├─ Publish event
   └─ Send notification
   
5. If all retries fail
   └─ Mark transaction as FAILED
   └─ Send notification: "Payment failed"
   └─ User can retry manually
```

---

## Idempotency (Critical for Money!)

### Problem: What if network fails after charge but before response?

```
Client:              Server:
POST /charge         1. Charge card: ₹100
    │                2. Add to wallet
    │                3. Generate response
    ├─────────────→  4. Send response
    X (Connection     (Response lost!)
      timeout)
    
Client retries:      Server:
POST /charge         1. Charge card: ₹100 again ❌ DOUBLE CHARGE!
    │
```

### Solution: Idempotency Key

```
Client sends unique key:
POST /charge
headers: {
  "Idempotency-Key": "unique-key-123456"
}

Server logic:
1. Check if Idempotency-Key already processed
   ├─ If YES: Return cached response (no duplicate charge)
   └─ If NO: Proceed with charge
   
2. Process charge
   
3. Store result with Idempotency-Key
   
4. Return response

Client retries with same key:
POST /charge
headers: {
  "Idempotency-Key": "unique-key-123456"
}
└─ Server returns: Already processed, here's the result
└─ No duplicate charge! ✅
```

---

## Scaling Strategy

### Traffic: 10M transactions/day

```
Average: 10M / 86400 sec ≈ 116 requests/sec
Peak: 1000-2000 requests/sec (festivals, sales)

Solution:

1. Load Balancer (Nginx)
   └─ Distribute across multiple API instances
   
2. Service Instances
   ├─ User Service: 3 instances (low load)
   ├─ Wallet Service: 5 instances (high load, critical)
   ├─ Payment Service: 4 instances
   └─ Auto-scale based on CPU/memory
   
3. Database Scaling
   ├─ Read Replicas (PostgreSQL)
   │  └─ Wallet reads from replicas
   │  └─ Writes always to master
   │
   ├─ Sharding (MongoDB)
   │  └─ Partition by user_id or merchant_id
   │  └─ Each shard handles subset of data
   │
   └─ Caching (Redis)
      └─ Cache wallet balance
      └─ Cache user profiles
      └─ TTL: 5 minutes for balance (strong consistency)
   
4. Message Queue (Kafka)
   └─ Buffer notifications (don't overload)
   └─ Process payment events asynchronously
   
5. CDN
   └─ Serve static assets (images, JS)
```

---

## Security Considerations

```
1. Data Encryption
   ├─ HTTPS for all API calls
   ├─ Encrypt sensitive data at rest (AES-256)
   └─ Encrypt payment card info (PCI-DSS)
   
2. Authentication
   ├─ JWT tokens with expiration
   ├─ Refresh tokens for long-lived sessions
   └─ MFA (Two-factor authentication)
   
3. Authorization
   ├─ Role-based access control (RBAC)
   ├─ User can only access own data
   └─ Admin access audited
   
4. Input Validation
   ├─ Validate all inputs (SQL injection prevention)
   ├─ Rate limiting (prevent brute force)
   └─ CAPTCHA on login failures
   
5. Fraud Detection
   ├─ Unusual transaction patterns
   ├─ Geolocation checks
   ├─ Device fingerprinting
   └─ Manual review for suspicious transactions
   
6. Audit Trail
   └─ Log all financial transactions
   └─ Immutable audit log
   └─ Compliance with regulations
```

---

## Monitoring & Alerting

```
Key Metrics:
- Transaction success rate (should be > 99.9%)
- Payment latency (p95, p99)
- Wallet balance consistency
- Failed transactions count
- Failed payment gateways

Alerts:
- Success rate drops below 95%
- Latency p99 > 500ms
- Kafka queue backed up
- Database replication lag > 5 sec
- Wallet balance mismatch detected
```

---

## Key Takeaway 🎯

**Paytm-like service = Complex distributed system**

Critical considerations:
1. **Strong Consistency** for wallets (ACID)
2. **Idempotency** to prevent double charges
3. **Async Processing** for notifications
4. **Event-Driven** for scalability
5. **Circuit Breakers** for external calls
6. **Monitoring** for reliability
7. **Security** for trust
