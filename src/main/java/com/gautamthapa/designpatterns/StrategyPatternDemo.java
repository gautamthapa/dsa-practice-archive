package com.gautamthapa.designpatterns;

/**
 * Strategy Pattern - Behavioral Pattern
 *
 * Problem: Different payment methods (Credit Card, UPI, Wallet, NetBanking)
 * Solution: Encapsulate each payment algorithm in separate class
 *           Use interface to make them interchangeable
 *
 * Benefits:
 * - Easy to add new payment methods
 * - Runtime algorithm selection
 * - Reduces code complexity (no if-else chains)
 * - Easy to test each strategy independently
 */

// ============= Strategy Interface =============
/**
 * Strategy interface - defines contract for all payment strategies
 */
 interface PaymentStrategy {
    /**
     * Process payment using specific strategy
     * @param amount - Amount to pay
     * @return true if payment successful, false otherwise
     */
    boolean pay(double amount);

    /**
     * Get payment method name
     * @return payment method name
     */
    String getPaymentMethod();
}

// ============= Concrete Strategies =============

/**
 * Concrete Strategy 1: Credit Card Payment
 */
 class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean pay(double amount) {
        // Validate card details
        if (!isCardValid()) {
            System.out.println("Invalid card details!");
            return false;
        }

        // Simulate payment processing
        System.out.println("Processing Credit Card Payment");
        System.out.println("Amount: " + amount);
        System.out.println("Card: ****" + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Payment successful!");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "CREDIT_CARD";
    }

    private boolean isCardValid() {
        return cardNumber != null && cvv != null && expiryDate != null;
    }
}

/**
 * Concrete Strategy 2: UPI Payment (BHIM, Google Pay, PhonePe)
 */
 class UPIPayment implements PaymentStrategy {
    private String upiId;
    private String pin;

    public UPIPayment(String upiId, String pin) {
        this.upiId = upiId;
        this.pin = pin;
    }

    @Override
    public boolean pay(double amount) {
        // Validate UPI
        if (!isUPIValid()) {
            System.out.println("Invalid UPI ID or PIN!");
            return false;
        }

        // Simulate UPI payment
        System.out.println("Processing UPI Payment");
        System.out.println("Amount: " + amount);
        System.out.println("UPI ID: " + upiId);
        System.out.println("Generating OTP...");
        System.out.println("OTP verified!");
        System.out.println("Payment successful!");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "UPI";
    }

    private boolean isUPIValid() {
        return upiId != null && upiId.contains("@") && pin != null;
    }
}

/**
 * Concrete Strategy 3: Wallet Payment (Paytm, Amazon Pay)
 */
 class WalletPayment implements PaymentStrategy {
    private double walletBalance;
    private String walletId;

    public WalletPayment(String walletId, double initialBalance) {
        this.walletId = walletId;
        this.walletBalance = initialBalance;
    }

    @Override
    public boolean pay(double amount) {
        // Check sufficient balance
        if (walletBalance < amount) {
            System.out.println("Insufficient wallet balance!");
            System.out.println("Available: " + walletBalance + ", Required: " + amount);
            return false;
        }

        // Deduct from wallet
        walletBalance -= amount;
        System.out.println("Processing Wallet Payment");
        System.out.println("Amount: " + amount);
        System.out.println("Wallet ID: " + walletId);
        System.out.println("Remaining balance: " + walletBalance);
        System.out.println("Payment successful!");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "WALLET";
    }

    public double getBalance() {
        return walletBalance;
    }

    public void addBalance(double amount) {
        walletBalance += amount;
    }
}

/**
 * Concrete Strategy 4: Net Banking Payment
 */
 class NetBankingPayment implements PaymentStrategy {
    private String accountNumber;
    private String bankCode;

    public NetBankingPayment(String accountNumber, String bankCode) {
        this.accountNumber = accountNumber;
        this.bankCode = bankCode;
    }

    @Override
    public boolean pay(double amount) {
        // Validate account
        if (!isAccountValid()) {
            System.out.println("Invalid account details!");
            return false;
        }

        // Simulate net banking payment
        System.out.println("Processing Net Banking Payment");
        System.out.println("Amount: " + amount);
        System.out.println("Bank: " + bankCode);
        System.out.println("Account: ****" + accountNumber.substring(accountNumber.length() - 4));
        System.out.println("Redirecting to bank website...");
        System.out.println("Payment successful!");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "NET_BANKING";
    }

    private boolean isAccountValid() {
        return accountNumber != null && bankCode != null;
    }
}

// ============= Context Class =============

/**
 * Context: Payment Processor
 * - Uses strategy to process payments
 * - Can switch strategies dynamically at runtime
 */
 class PaymentProcessor {
    private PaymentStrategy paymentStrategy;
    private double totalAmount;

    /**
     * Set payment strategy (can be changed anytime)
     */
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    /**
     * Process payment using selected strategy
     */
    public boolean processPayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy selected!");
            return false;
        }

        System.out.println("\n===== Payment Processing =====");
        System.out.println("Method: " + paymentStrategy.getPaymentMethod());

        boolean result = paymentStrategy.pay(amount);

        if (result) {
            totalAmount += amount;
            System.out.println("Total processed: " + totalAmount);
        }

        System.out.println("============================\n");
        return result;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

// ============= Demo: Using Strategy Pattern =============

/**
 * Example: E-commerce checkout process
 * Different users choose different payment methods
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // User 1: Pays with Credit Card
        System.out.println("===== Customer 1: Credit Card Payment =====");
        PaymentStrategy creditCard = new CreditCardPayment("1234567890123456", "123", "12/25");
        processor.setPaymentStrategy(creditCard);
        processor.processPayment(5000);

        // User 2: Pays with UPI
        System.out.println("\n===== Customer 2: UPI Payment =====");
        PaymentStrategy upi = new UPIPayment("user@upi", "1234");
        processor.setPaymentStrategy(upi);
        processor.processPayment(3000);

        // User 3: Pays with Wallet
        System.out.println("\n===== Customer 3: Wallet Payment =====");
        WalletPayment wallet = new WalletPayment("PAYTM123", 10000);
        processor.setPaymentStrategy(wallet);
        processor.processPayment(2000);

        // User 4: Wallet has insufficient balance
        System.out.println("\n===== Customer 4: Wallet (Insufficient Balance) =====");
        WalletPayment wallet2 = new WalletPayment("PAYTM456", 500);
        processor.setPaymentStrategy(wallet2);
        processor.processPayment(1000);  // Will fail

        // User 5: Net Banking
        System.out.println("\n===== Customer 5: Net Banking =====");
        PaymentStrategy netBanking = new NetBankingPayment("987654321", "HDFC");
        processor.setPaymentStrategy(netBanking);
        processor.processPayment(4500);

        System.out.println("\n===== Summary =====");
        System.out.println("Total successfully processed: " + processor.getTotalAmount());
    }
}

/*
 * Output:
 * ===== Customer 1: Credit Card Payment =====
 * ===== Payment Processing =====
 * Method: CREDIT_CARD
 * Processing Credit Card Payment
 * Amount: 5000.0
 * Card: ****3456
 * Payment successful!
 * Total processed: 5000.0
 * ============================
 *
 * ===== Customer 2: UPI Payment =====
 * ===== Payment Processing =====
 * Method: UPI
 * Processing UPI Payment
 * Amount: 3000.0
 * UPI ID: user@upi
 * Generating OTP...
 * OTP verified!
 * Payment successful!
 * Total processed: 8000.0
 * ============================
 *
 * ===== Customer 3: Wallet Payment =====
 * ===== Payment Processing =====
 * Method: WALLET
 * Processing Wallet Payment
 * Amount: 2000.0
 * Wallet ID: PAYTM123
 * Remaining balance: 8000.0
 * Payment successful!
 * Total processed: 10000.0
 * ============================
 *
 * ===== Customer 4: Wallet (Insufficient Balance) =====
 * ===== Payment Processing =====
 * Method: WALLET
 * Processing Wallet Payment
 * Amount: 1000.0
 * Wallet ID: PAYTM456
 * Insufficient wallet balance!
 * Available: 500.0, Required: 1000.0
 * ============================
 *
 * ===== Customer 5: Net Banking =====
 * ===== Payment Processing =====
 * Method: NET_BANKING
 * Processing Net Banking Payment
 * Amount: 4500.0
 * Bank: HDFC
 * Account: ****4321
 * Redirecting to bank website...
 * Payment successful!
 * Total processed: 14500.0
 * ============================
 *
 * ===== Summary =====
 * Total successfully processed: 14500.0
 */

/*
 * Key Concepts:
 *
 * 1. ENCAPSULATION: Each payment method is encapsulated in its own class
 *
 * 2. INTERCHANGEABILITY: All strategies implement same interface
 *    Can swap strategies at runtime without changing client code
 *
 * 3. OPEN/CLOSED PRINCIPLE:
 *    - Open for extension (add new payment methods)
 *    - Closed for modification (existing code doesn't change)
 *
 * 4. NO CONDITIONAL LOGIC:
 *    Bad:  if (type == CREDIT_CARD) {...} else if (type == UPI) {...}
 *    Good: strategy.pay(amount)  // Works for all types
 *
 * 5. REAL-WORLD APPLICATIONS:
 *    - Payment methods (as shown above)
 *    - Sorting algorithms (merge sort, quick sort, bubble sort)
 *    - Compression algorithms (ZIP, RAR, 7Z)
 *    - Route finding (shortest path, fastest route, cheapest route)
 *    - Caching strategies (LRU, LFU, FIFO)
 */