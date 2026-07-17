# CAP Theorem 🧩

Fundamental theorem about distributed systems: **You can pick only 2 out of 3**.

---

## The Three Properties

### 1. **Consistency (C)** 📊
All nodes see the same data at the same time. No stale reads.

```
Write "balance = 100" to Node 1
    ↓
All nodes (Node 2, 3, 4) immediately see "balance = 100"
    ↓
No node returns old data (90)
```

#### Strong Consistency:
```java
// ACID transactions (Monolithic DB)
updateBalance(from, to, amount) {
    debit(from, amount);   // from: 100 → 90
    credit(to, amount);    // to: 50 → 60
    // Both succeed or both fail
}

// Everyone sees 90 and 60 immediately
```

#### Eventual Consistency:
```
Master: balance = 100
    ↓
Propagate to all replicas (takes time)
    ↓
During propagation:
  - Replica 1: sees balance = 90 (stale)
  - Replica 2: sees balance = 90 (stale)
    ↓
After sync completes: all see balance = 100
```

---

### 2. **Availability (A)** 🟢
System is always responsive. Requests never fail (always get a response).

```
100% uptime
Every request gets a response (not error/timeout)
```

#### Available System:
```
GET /user/123
  ├─ Node 1 is down
  ├─ Node 2 is down
  └─ Node 3 still responds ✅
```

#### Unavailable System:
```
GET /user/123
  ├─ Node 1 is down
  ├─ Node 2 is down
  └─ Node 3 also down
     → Request fails ❌
```

---

### 3. **Partition Tolerance (P)** 🌐
System continues operating even when network partitions occur (nodes can't communicate).

```
Normal:
Node 1 ↔ Node 2 ↔ Node 3
All can talk to each other ✅

Network Partition:
Node 1 ↔ Node 2    (isolated)
Node 3 ↔ Node 4 ↔ Node 5

Partition Tolerant System:
- Partition A keeps working
- Partition B keeps working
- They sync when reconnected

Non-Partition Tolerant:
- System stops working
- Waits for all nodes to be connected
```

---

## CAP Trade-offs

### Why Can't You Have All Three?

During a network partition, you must choose:

```
Network Partition Occurs
    ↓
Choose: Consistency OR Availability
    ↓
Cannot have BOTH during partition

If you want Consistency:
  → Reject requests to maintain consistency
  → Lose Availability

If you want Availability:
  → Keep responding (may be inconsistent)
  → Lose Consistency
```

---

## Three Combinations

### 1. **CP: Consistency + Partition Tolerance** 📊
(Sacrificing Availability)

```
Network Partition
    ↓
Nodes can't communicate
    ↓
To maintain consistency:
  → Reject all requests ❌
  → "System unavailable"
    ↓
After partition heals:
  → Nodes sync
  → Consistency maintained ✅
```

#### Real Examples:
- **MongoDB** (strong consistency by default)
- **PostgreSQL** (ACID transactions)
- **Google Spanner** (distributed but consistent)

#### Use Case:
- Banking (can't have inconsistent balances)
- Medical records (can't have stale patient data)
- Nuclear power plants (consistency critical)

#### Problem:
```
Network issue → System down
→ High availability sacrificed
→ User can't access system
```

---

### 2. **AP: Availability + Partition Tolerance** 🟢
(Sacrificing Consistency)

```
Network Partition
    ↓
Nodes can't communicate
    ↓
To maintain availability:
  → Keep accepting requests ✅
  → Nodes diverge (inconsistent)
    ↓
After partition heals:
  → Eventual consistency kicks in
  → Nodes eventually sync
```

#### Real Examples:
- **Cassandra** (eventual consistency)
- **DynamoDB** (high availability)
- **Redis** (with replication)

#### Use Case:
- Social media feeds (stale OK, availability critical)
- Caching layers (eventual consistency OK)
- Recommendation systems (eventual consistency OK)

#### Problem:
```
User A writes tweet → Posted on Node 1
User B reads → Might not see tweet immediately
→ Temporary inconsistency
→ Consistency comes later (eventual)
```

---

### 3. **CA: Consistency + Availability** 💾
(No Partition Tolerance - Single Node/Replicas in same datacenter)

```
Single Database (no partitions possible)
or
All replicas in same datacenter
    ↓
Can achieve Consistency + Availability
    ↓
But network failure → System down
    ↓
Not suitable for distributed systems
```

#### Real Examples:
- **Traditional SQL** (MySQL, PostgreSQL single instance)
- **Google Cloud SQL** (single region)

#### Problem:
```
Network partition between datacenters
→ System chooses CA (impossible)
→ System must choose CP or AP
→ One of them fails anyway
```

---

## Visual: CAP Triangle

```
          Consistency (C)
                 ▲
                /│\
               / │ \
              /  │  \
             /CP │ CA\ (impossible)
            /    │    \
           /     │     \
          /      │      \
         /       │       \
        /        │        \
       /____ P─ Partition _\___
      Availability (A)    AP


CP Systems: 
  ✅ Consistent
  ✅ Partition tolerant  
  ❌ Not always available

AP Systems:
  ✅ Available
  ✅ Partition tolerant
  ❌ Eventually consistent

CA Systems:
  ✅ Consistent
  ✅ Available
  ❌ Fails during partitions
```

---

## Real-World Example: Paytm-like Platform

### Wallet Service (MONEY - Critical)
```
✅ Choose: CP (Consistency + Partition)
  → Can't afford inconsistent balances
  → If network partition → Reject updates
  → Consistency over Availability

Implementation:
  Database: PostgreSQL (strong ACID)
  Strategy: Distributed ACID transactions
  Response: "Service temporarily unavailable" if partition
```

### Order History (Not Critical)
```
✅ Choose: AP (Availability + Partition)
  → Can show stale order data
  → If network partition → Still respond
  → Availability over Consistency

Implementation:
  Database: Cassandra (eventual consistency)
  Strategy: Replication with eventual sync
  Response: Returns data (might be slightly old)
```

### User Profile (Less Critical)
```
✅ Choose: AP (Availability + Partition)
  → Profile can be slightly stale
  → User sees old profile picture briefly
  → Availability critical (user shouldn't see error)

Implementation:
  Database: DynamoDB
  Strategy: Immediate eventual consistency
  Cache: Redis (for even faster responses)
```

---

## Decision Flowchart

```
Do you need consistency 100%?
├─ YES (Banking, Medical)
│   └─ Choose CP
│
└─ NO (Social, Cache, Feed)
    └─ Do you need high availability?
       ├─ YES (User-facing, traffic spike)
       │   └─ Choose AP
       │
       └─ NO
           └─ Single region OK? 
              ├─ YES (Internal service)
              │   └─ Can use CA
              │
              └─ NO
                  └─ Choose AP (distributed)
```

---

## Misconception ⚠️

"We'll have all 3 properties!"

**Reality:** In a distributed system with network partitions:
- Network partition WILL happen
- You MUST choose: Consistency OR Availability
- You cannot avoid this choice

**BUT:** With proper design:
- CP systems can be fast enough
- AP systems can have quick eventual consistency (milliseconds)
- Use AP for most, CP for critical data

---

## Key Takeaway 🎯

**CAP Theorem = Know your trade-offs**

- **Financial systems**: Choose CP (accuracy over speed)
- **Social media**: Choose AP (speed over accuracy)
- **User profiles**: Choose AP (with cache for speed)

Design your database and replication strategy based on what you can't sacrifice!