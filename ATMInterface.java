import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Enter a positive value.");
        } else if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful! Remaining balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Enter a positive value.");
        } else {
            account.deposit(amount);
            System.out.println("Deposit successful! New balance: " + account.getBalance());
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount userAccount = new BankAccount(1000.0); 
        ATM atm = new ATM(userAccount);

        int choice;

        System.out.println("===== WELCOME TO ATM MACHINE =====");

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double wAmount = sc.nextDouble();
                    atm.withdraw(wAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double dAmount = sc.nextDouble();
                    atm.deposit(dAmount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
