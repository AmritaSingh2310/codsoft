package ATMmachine;
import java.util.Scanner;

class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance = balance + amount;
         System.out.println("Successfully deposited: " + amount);
         System.out.println("------------------------------------------");
     } else {
         System.out.println("Invalid deposit amount.");
         System.out.println("------------------------------------------");
     }
 }

 public boolean withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Successfully withdrawn: " + amount);
         System.out.println("------------------------------------------");
         return true;
     } else if (amount > balance) {
         System.out.println("Insufficient balance!");
         System.out.println("------------------------------------------");
         return false;
     } else {
         System.out.println("Invalid withdrawal amount.");
         System.out.println("------------------------------------------");
         return false;
     }
 }

 public double getBalance() {
     return balance;
 }
}
class ATM {
 private BankAccount userAccount;
 private Scanner sc;

 // Constructor
 public ATM(BankAccount account) {
     this.userAccount = account;
     this.sc = new Scanner(System.in);
 }

 public void showMenu() {
     while (true) {
         System.out.println("\n===== Welcome to the ATM machine =====");
         System.out.println("------------------------------------------");
         System.out.println("1. Withdraw");
         System.out.println("2. Deposit");
         System.out.println("3. Check Balance");
         System.out.println("4. Exit");
         System.out.print("Choose an option: ");

         int choice = sc.nextInt();

         switch (choice) {
             case 1:
                 performWithdrawal();
                 break;
             case 2:
                 AmountDeposit();
                 break;
             case 3:
                 checkBalance();
                 break;
             case 4:
                 System.out.println("Thank you for using the ATM. Goodbye!");
                 System.out.println("------------------------------------------");
                 System.out.println("============================================");
                 return;
             default:
                 System.out.println("Invalid option. Please try again.");
                 System.out.println("------------------------------------------");
         }
     }
 }

 private void performWithdrawal() {
     System.out.print("Enter withdrawal amount: ");
     double amount = sc.nextDouble();
     userAccount.withdraw(amount);
 }

 private void AmountDeposit() {
     System.out.print("Enter deposit amount: ");
     double amount = sc.nextDouble();
     userAccount.deposit(amount);
 }
 private void checkBalance() {
     System.out.println("Your current balance is: " + userAccount.getBalance());
 }
}
public class ATMSystem {
 public static void main(String[] args) {
     BankAccount myAccount = new BankAccount(1000.00); // Initial balance: $1000
     ATM atm = new ATM(myAccount);
     atm.showMenu();
 }
}
