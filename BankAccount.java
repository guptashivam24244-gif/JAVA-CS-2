// 2. Bank Account with Constructor Overloading //
class BankAccount {
    String accountHolder;
    int accountNumber;
    private float balance;

    BankAccount(int a, String n) {
        accountNumber = a;
        accountHolder = n;
    
    }

    BankAccount(int a, String n, float b) {
        accountNumber = a;
        accountHolder = n;
        balance = b;
    }

    public void deposit(float amount) {
        balance = balance + amount;
        System.out.println("Amount Deposited: " + amount);
        System.out.println("Updated Balance: " + balance);
    }

    public void withdraw(float amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdrawn Amount: " + amount);
            System.out.println("Updated Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Balance: " + balance);
    }
}
 class bankMain {
    public static void main(String[] args) {

        BankAccount b1 = new BankAccount(123, "AJAY");
        b1.displayAccount();

        BankAccount b2 = new BankAccount(456, "RAVI", 1000.0f);
        b2.displayAccount();

        b2.deposit(2000.0f);
        b2.withdraw(500.0f);
    }
}
