# Design Patterns 🏛️

Design Patterns are reusable solutions to common problems in software design. They provide templates for writing maintainable and scalable code.

---

## Three Categories of Design Patterns

### 1. **Creational Patterns** 🏗️
Concerned with object creation mechanisms.

| Pattern | Purpose | Use Case |
|---------|---------|----------|
| **Singleton** | Ensures only one instance of a class | Database connection, Logger |
| **Factory** | Creates objects without specifying classes | Creating different payment methods |
| **Abstract Factory** | Creates families of related objects | UI components for different OS |
| **Builder** | Constructs complex objects step-by-step | Building complex configurations |
| **Prototype** | Creates objects by cloning | Deep copy of objects |

#### Example: Singleton Pattern
```java
public class DatabaseConnection {
    private static DatabaseConnection instance;
    
    private DatabaseConnection() {}
    
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}

// Usage: Same instance always
DatabaseConnection db1 = DatabaseConnection.getInstance();
DatabaseConnection db2 = DatabaseConnection.getInstance();
// db1 == db2 (same object)
```

---

### 2. **Structural Patterns** 🔗
Concerned with object composition creating new functionalities.

| Pattern | Purpose | Use Case |
|---------|---------|----------|
| **Adapter** | Makes incompatible interfaces compatible | Converting old code to new interfaces |
| **Decorator** | Adds new functionality to objects dynamically | Adding features to coffee (sugar, milk) |
| **Facade** | Provides simplified interface to complex subsystem | Database abstraction layer |
| **Proxy** | Controls access to another object | Lazy loading, security checks |
| **Bridge** | Decouples abstraction from implementation | Separating OS from graphics |
| **Composite** | Treats individual objects and compositions uniformly | File system (folders and files) |

#### Example: Decorator Pattern
```java
// Base component
public interface Coffee {
    double cost();
    String description();
}

public class SimpleCoffee implements Coffee {
    public double cost() { return 5.0; }
    public String description() { return "Simple Coffee"; }
}

// Decorator
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) { this.coffee = coffee; }
}

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }
    public double cost() { return coffee.cost() + 1.0; }
    public String description() { return coffee.description() + ", Milk"; }
}

// Usage
Coffee coffee = new SimpleCoffee();              // Cost: 5
coffee = new MilkDecorator(coffee);              // Cost: 6
coffee = new SugarDecorator(coffee);             // Cost: 6.5
```

---

### 3. **Behavioral Patterns** 🎭
Concerned with object collaboration and responsibility distribution.

| Pattern | Purpose | Use Case |
|---------|---------|----------|
| **Strategy** | Encapsulates algorithms to make them interchangeable | Different payment methods |
| **Observer** | Notifies multiple objects about state changes | Event listeners, publish-subscribe |
| **Command** | Encapsulates a request as an object | Undo/Redo functionality |
| **State** | Allows object behavior to change based on state | Order status (Pending, Shipped, Delivered) |
| **Template Method** | Defines skeleton of algorithm in base class | Database operations (connect, query, close) |
| **Iterator** | Accesses elements of collection sequentially | Traversing arrays/lists |
| **ChainOfResponsibility** | Passes request along a chain of handlers | Logger levels, authentication filters |

#### Example: Strategy Pattern
```java
// Strategy interface
public interface PaymentStrategy {
    void pay(double amount);
}

// Different strategies
public class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

public class UPIPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

// Context
public class PaymentProcessor {
    private PaymentStrategy strategy;
    
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void processPayment(double amount) {
        strategy.pay(amount);
    }
}

// Usage
PaymentProcessor processor = new PaymentProcessor();
processor.setStrategy(new CreditCardPayment());
processor.processPayment(1000);  // Credit Card

processor.setStrategy(new UPIPayment());
processor.processPayment(500);   // UPI
```

---

## Pattern Selection Guide

```
When should I use each pattern?

Creating Objects?
├─ Need only one instance? → Singleton
├─ Complex creation? → Builder
├─ Multiple types? → Factory
└─ Object families? → Abstract Factory

Composing Objects?
├─ Simplify complex subsystem? → Facade
├─ Add features dynamically? → Decorator
├─ Control access? → Proxy
└─ Treat parts & whole uniformly? → Composite

Distributing Responsibility?
├─ Different algorithms? → Strategy
├─ Notify multiple objects? → Observer
├─ Encapsulate request? → Command
├─ Object behavior by state? → State
└─ Chain of handlers? → Chain of Responsibility
```

---

## Real-World Applications

### Enterprise (EPAM level)
- **Strategy Pattern**: Different calculation engines based on business rules
- **Observer Pattern**: Event-driven microservices
- **Decorator Pattern**: Logging, caching, security wrappers
- **Factory Pattern**: ORM entity creation
- **Chain of Responsibility**: Request processing pipelines

### Frameworks
- **Spring**: Singleton, Factory, Proxy, Decorator patterns
- **Java Collections**: Iterator, Factory patterns
- **Servlet Filters**: Chain of Responsibility pattern

