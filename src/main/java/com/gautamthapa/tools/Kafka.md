# Kafka 📨

Distributed messaging system for building real-time data pipelines and streaming applications.

---

## What is Kafka?

Apache Kafka is a distributed streaming platform that:
- **Publishes** and **subscribes** to streams of records
- **Stores** records in a fault-tolerant way
- **Processes** streams of records as they occur

Think of it as a high-performance messaging queue on steroids.

---

## Core Concepts

### 1. **Topics** 📚
A topic is a category or feed name to which records are published.

```
Topic: "order-events"
├─ Order Created
├─ Payment Processed
├─ Inventory Updated
└─ Notification Sent

Topic: "user-events"
├─ User Registered
├─ User Updated
└─ User Deleted
```

### 2. **Producers** 📤
Applications that publish messages to topics.

### 3. **Consumers** 📥
Applications that subscribe to topics and process messages.

### 4. **Partitions** 🔀
Topics are split into partitions for parallel processing.

```
Topic: "orders" (3 partitions)

Partition 0: Order#1, Order#4, Order#7, ...
Partition 1: Order#2, Order#5, Order#8, ...
Partition 2: Order#3, Order#6, Order#9, ...
```

### 5. **Consumer Groups** 👥
Multiple consumers processing same topic independently.

---

## Real-World Example: Paytm-like Platform

Event-driven order flow with Kafka

---

## Kafka vs RabbitMQ

| Feature | Kafka | RabbitMQ |
|---------|-------|----------|
| **Throughput** | Very High | Medium |
| **Scalability** | Horizontal | Vertical |
| **Persistence** | Excellent | Good |
| **Stream Processing** | Native | No |

---

## Use Cases

✅ Event Streaming  
✅ Real-time Analytics  
✅ Microservices Communication  
✅ Log Aggregation  
✅ Stream Processing

---

## Key Takeaway 🎯

**Kafka = Distributed event streaming platform for microservices**