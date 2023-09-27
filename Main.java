import java.util.Scanner;
import java.util.InputMismatchException;

class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;
    
    public BankAccount(int accountNumber, String accountName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialBalance;
    }
    
    public boolean depositMoney(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance = balance + amount;
        return true;
    }
    
    public boolean withdrawMoney(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance = balance - amount;
        return true;
    }
    
    public double checkBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int accountNumber;
        String accountName;
        double initialBalance;

        while (true) {
            try {
                System.out.print("Enter account number: ");
                accountNumber = scanner.nextInt();
                if (accountNumber >= 0) {
                    scanner.nextLine();
                    break;
                }
                System.out.println("Invalid input. Account number is less than 0.");
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                // Clear the invalid input from the scanner
                scanner.nextLine();
            }
        }
        
        System.out.print("Enter account holder name: ");
        accountName = scanner.nextLine();

        while (true) {
            try {
                System.out.print("Enter initial balance: ");
                initialBalance = scanner.nextDouble();
                if (initialBalance >= 0) {
                    break;
                }
                System.out.println("Invalid input. Balance is less than 0.");
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                // Clear the invalid input from the scanner
                scanner.nextLine();
            }
        }
        
        BankAccount account = new BankAccount(accountNumber, accountName, initialBalance);
        
        while (true) {
            try {
                System.out.println("\nBank Account Menu:");
                System.out.println("1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice (1/2/3/4): ");
    
                int choice = scanner.nextInt();
                
                switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (account.depositMoney(depositAmount)) {
                        System.out.print("Deposit successfully!\n");
                    }
                    else {
                        System.out.print("Deposit unsuccessfully!\n");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdrawMoney(withdrawAmount)) {
                        System.out.print("Withdraw successfully!\n");
                    }
                    else {
                        System.out.print("Withdraw unsuccessfully!\n");
                    }
                    break;
                case 3:
                    double balance = account.checkBalance();
                    System.out.println("Account Balance: $" + balance);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid input.");
                // Clear the invalid input from the scanner
                scanner.nextLine();
            }
        
        }
    }
}
