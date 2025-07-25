import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        sc.nextLine(); // consume newline

        BankAccount account = new BankAccount(name, balance);

        while (true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;
                case 3:
                    System.out.println("💰 Current Balance: " + account.getBalance());
                    break;
                case 0:
                    System.out.println("👋 Exiting...");
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
