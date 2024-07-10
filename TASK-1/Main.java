import java.util.Scanner;
import java.util.ArrayList;

public class ATM {
    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;

    public ATM(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: " + amount);
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: " + amount);
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void changePin(int newPin) {
        pin = newPin;
        System.out.println("PIN changed successfully");
    }

    public void transactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public boolean authenticate(int inputPin) {
        return inputPin == pin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000.0, 1234); // initial balance and PIN

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double amount = scanner.nextDouble();
                    atm.withdraw(amount);
                    break;
                case 3:
                    System.out.println("Enter deposit amount:");
                    amount = scanner.nextDouble();
                    atm.deposit(amount);
                    break;
                case 4:
                    System.out.println("Enter new PIN:");
                    int newPin = scanner.nextInt();
                    atm.changePin(newPin);
                    break;
                case 5:
                    atm.transactionHistory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }

            
            }
        }
    }

