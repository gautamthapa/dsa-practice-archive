# SOLID Principles 🏗️

Five design principles that make software more maintainable, scalable, and testable.

---

## Overview

| Principle | Full Form | Goal |
|-----------|-----------|------|
| **S** | Single Responsibility | One reason to change |
| **O** | Open/Closed | Open for extension, closed for modification |
| **L** | Liskov Substitution | Subtypes replaceable for base types |
| **I** | Interface Segregation | Many specific interfaces > one general |
| **D** | Dependency Inversion | Depend on abstractions, not concrete |

---

## 1. Single Responsibility Principle (SRP) 📍

**A class should have only one reason to change.**

Each class should do ONE thing and do it well.

### ❌ Bad Example:
```java
// Violates SRP: Too many responsibilities
public class Order {
    // Responsibility 1: Data management
    private String orderId;
    private double total;
    
    public void createOrder(OrderData data) { }
    public void saveToDatabase() { }
    
    // Responsibility 2: Email notification
    public void sendEmailConfirmation() { }
    
    // Responsibility 3: Payment processing
    public void processPayment() { }
    
    // Responsibility 4: Inventory management
    public void updateInventory() { }
}
```

Problems:
- Hard to test (need mock email, payment, DB)
- Changes to email system affect Order class
- Reusing Order class includes unwanted functionality
- High coupling, low cohesion

### ✅ Good Example:
```java
// Each class has single responsibility
public class Order {
    private String orderId;
    private double total;
    
    public Order(String id, double total) {
        this.orderId = id;
        this.total = total;
    }
    
    // Only order data management
    public String getOrderId() { return orderId; }
    public double getTotal() { return total; }
}

public class OrderRepository {
    // Responsibility: Database operations
    public void save(Order order) { }
    public Order findById(String id) { }
}

public class OrderNotificationService {
    // Responsibility: Sending notifications
    public void sendConfirmationEmail(Order order) { }
}

public class PaymentService {
    // Responsibility: Payment processing
    public boolean processPayment(Order order) { }
}

public class InventoryService {
    // Responsibility: Inventory management
    public void updateInventory(Order order) { }
}
```

Benefits:
- Easy to test each class independently
- Changes to email logic don't affect Order class
- Can reuse Order class without extra baggage
- Clear responsibilities

---

## 2. Open/Closed Principle (OCP) 🔓

**Software entities should be open for extension but closed for modification.**

You should be able to add new functionality without modifying existing code.

### ❌ Bad Example:
```java
public class PaymentProcessor {
    public void process(String paymentType, double amount) {
        if (paymentType.equals("CREDIT_CARD")) {
            // Credit card logic
            System.out.println("Processing credit card...");
        } else if (paymentType.equals("UPI")) {
            // UPI logic
            System.out.println("Processing UPI...");
        } else if (paymentType.equals("NETBANKING")) {
            // Netbanking logic
            System.out.println("Processing netbanking...");
        }
        // Adding new payment type? Modify this class!
    }
}
```

Problem: To add new payment method, must modify existing class (risky!)

### ✅ Good Example:
```java
// Interface for extension
public interface PaymentStrategy {
    void processPayment(double amount);
}

// Implementations (closed for modification, can extend)
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card: " + amount);
    }
}

public class UPIPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI: " + amount);
    }
}

public class NetBankingPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing netbanking: " + amount);
    }
}

// Processor: doesn't change when new methods added
public class PaymentProcessor {
    public void process(PaymentStrategy strategy, double amount) {
        strategy.processPayment(amount);
    }
}

// Usage
PaymentProcessor processor = new PaymentProcessor();
processor.process(new CreditCardPayment(), 1000);

// To add new method: Just create new class! No modification!
public class WalletPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing wallet: " + amount);
    }
}
processor.process(new WalletPayment(), 500);
```

Benefits:
- Add new payment types without modifying PaymentProcessor
- Existing code stays stable (less chance of bugs)
- Easy to test each new payment type
- Better code reusability

---

## 3. Liskov Substitution Principle (LSP) 🔄

**Subclasses must be substitutable for their base classes without breaking functionality.**

If S is a subtype of T, then T can be replaced by S.

### ❌ Bad Example:
```java
public class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

public class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow flying fast!");
    }
}

public class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}

// Problem:
public void makeBirdFly(Bird bird) {
    bird.fly();  // Works for Sparrow, breaks for Penguin!
}
```

Problem: Penguin violates the contract that Bird can fly

### ✅ Good Example:
```java
public interface Bird {
    void move();
}

public class Sparrow implements Bird {
    @Override
    public void move() {
        System.out.println("Sparrow flying fast!");
    }
}

public class Penguin implements Bird {
    @Override
    public void move() {
        System.out.println("Penguin swimming!");
    }
}

// Now any Bird subclass can be used interchangeably
public void makeBirdMove(Bird bird) {
    bird.move();  // Works for any bird!
}

makeBirdMove(new Sparrow());  // ✅ Flies
makeBirdMove(new Penguin());  // ✅ Swims
```

Benefits:
- Predictable behavior
- Can use polymorphism safely
- Fewer runtime errors

---

## 4. Interface Segregation Principle (ISP) ✂️

**Clients should not be forced to implement interfaces they don't use.**

Create many specific interfaces instead of one large general interface.

### ❌ Bad Example:
```java
// One large interface
public interface Worker {
    void work();
    void eat();
    void sleep();
    void supervise();  // Only managers do this
    void code();       // Only developers do this
}

public class Developer implements Worker {
    public void work() { }
    public void eat() { }
    public void sleep() { }
    
    @Override
    public void supervise() {
        // Developer doesn't supervise!
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void code() { }  // Developer codes
}

public class Manager implements Worker {
    public void work() { }
    public void eat() { }
    public void sleep() { }
    
    @Override
    public void supervise() { }  // Manager supervises
    
    @Override
    public void code() {
        // Manager doesn't code!
        throw new UnsupportedOperationException();
    }
}
```

Problem: Both classes forced to implement methods they don't need

### ✅ Good Example:
```java
// Specific interfaces
public interface Workable {
    void work();
}

public interface Eatable {
    void eat();
}

public interface Sleepable {
    void sleep();
}

public interface Supervisable {
    void supervise();
}

public interface Codable {
    void code();
}

// Developer only implements what needed
public class Developer implements Workable, Eatable, Sleepable, Codable {
    @Override
    public void work() { System.out.println("Working..."); }
    
    @Override
    public void eat() { System.out.println("Eating..."); }
    
    @Override
    public void sleep() { System.out.println("Sleeping..."); }
    
    @Override
    public void code() { System.out.println("Coding..."); }
}

// Manager implements different interfaces
public class Manager implements Workable, Eatable, Sleepable, Supervisable {
    @Override
    public void work() { System.out.println("Working..."); }
    
    @Override
    public void eat() { System.out.println("Eating..."); }
    
    @Override
    public void sleep() { System.out.println("Sleeping..."); }
    
    @Override
    public void supervise() { System.out.println("Supervising..."); }
}
```

Benefits:
- No forced implementations
- Cleaner, more focused code
- Easier to test
- Better separation of concerns

---

## 5. Dependency Inversion Principle (DIP) 🔌

**High-level modules should not depend on low-level modules. Both should depend on abstractions.**

Depend on interfaces/abstractions, not concrete implementations.

### ❌ Bad Example:
```java
// Low-level module (concrete)
public class MySQLDatabase {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

// High-level module (depends on concrete MySQL)
public class UserService {
    private MySQLDatabase database = new MySQLDatabase();  // ❌ Direct dependency
    
    public void createUser(String name) {
        database.save(name);  // Tightly coupled!
    }
}

// Problem: Can't switch to PostgreSQL without modifying UserService!
```

Problem: UserService tightly coupled to MySQL implementation

### ✅ Good Example:
```java
// Abstraction
public interface Database {
    void save(String data);
}

// Low-level modules depend on abstraction
public class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

public class PostgreSQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to PostgreSQL: " + data);
    }
}

// High-level module depends on abstraction (not concrete)
public class UserService {
    private Database database;  // ✅ Depends on interface
    
    // Inject concrete implementation
    public UserService(Database database) {
        this.database = database;
    }
    
    public void createUser(String name) {
        database.save(name);  // Works with any Database!
    }
}

// Usage: Can switch implementations easily
UserService service1 = new UserService(new MySQLDatabase());
UserService service2 = new UserService(new PostgreSQLDatabase());  // Easy switch!
```

Benefits:
- Loosely coupled
- Easy to swap implementations
- Easier to test (inject mock database)
- Flexible and maintainable

---

## SOLID in Enterprise Applications

### UserService Example:
```java
@Service
public class UserService {
    
    // Dependency Inversion: Depend on abstraction
    private UserRepository userRepository;
    private EmailService emailService;
    private LoggingService loggingService;
    
    // Constructor Injection (DIP)
    public UserService(UserRepository repo, EmailService email, LoggingService log) {
        this.userRepository = repo;
        this.emailService = email;
        this.loggingService = log;
    }
    
    // Single Responsibility: Only user business logic
    public User createUser(UserRequest request) {
        loggingService.info("Creating user: " + request.getEmail());
        
        User user = new User(request);
        userRepository.save(user);
        
        // Separate services handle notifications
        emailService.sendWelcomeEmail(user);
        
        return user;
    }
}

// Open/Closed: Can extend without modifying
public interface EmailService {  // Abstraction
    void sendWelcomeEmail(User user);
}

public class GmailEmailService implements EmailService {  // Extension
    @Override
    public void sendWelcomeEmail(User user) {
        System.out.println("Sending via Gmail: " + user.getEmail());
    }
}

public class SendgridEmailService implements EmailService {  // Another extension
    @Override
    public void sendWelcomeEmail(User user) {
        System.out.println("Sending via Sendgrid: " + user.getEmail());
    }
}

// Interface Segregation: Specific interfaces
public interface UserRepository {
    User save(User user);
    User findById(String id);
}
```

---

## Benefits of Following SOLID

✅ **Maintainable**: Easier to understand and modify code  
✅ **Testable**: Can test components independently  
✅ **Scalable**: Easy to add new features  
✅ **Flexible**: Can swap implementations  
✅ **Reusable**: Components can be reused in other projects

---

## Common SOLID Violations

| Violation | Example | Fix |
|-----------|---------|-----|
| Multiple responsibilities | Service does business logic + database + email | Split into separate classes |
| Hard to extend | If-else for each type | Use polymorphism (Strategy pattern) |
| Rigid inheritance | Child breaks parent contract | Use composition, interfaces |
| Unused methods | Interface has methods clients don't need | Split into smaller interfaces |
| Concrete dependencies | `new DatabaseImpl()` directly | Inject via constructor |

---

## Key Takeaway 🎯

**SOLID = Write code that's:**
- Easy to read and understand
- Easy to modify and extend
- Easy to test
- Easy to reuse
- Resistant to breaking changes

Start with SOLID, thank yourself later when requirements change!