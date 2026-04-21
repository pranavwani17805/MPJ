import java.io.*;
import java.util.*;

class Account implements Serializable {
    int id;
    double balance;

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }
}

public class BankApp {

    static final String FILE_PATH = "accounts.dat";
    static HashMap<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        loadAccounts();

        while (true) {
            showMenu();
            System.out.print("Enter option: ");
            int choice = input.nextInt();

            try {
                switch (choice) {
                    case 1:
                        createAccount(input);
                        break;
                    case 2:
                        deposit(input);
                        break;
                    case 3:
                        withdraw(input);
                        break;
                    case 4:
                        checkBalance(input);
                        break;
                    case 5:
                        saveAccounts();
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void showMenu() {
        System.out.println("\n===== BANK SYSTEM =====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
    }

    static void createAccount(Scanner input) throws Exception {
        System.out.print("Enter ID (1-20): ");
        int id = input.nextInt();

        if (accounts.containsKey(id)) {
            throw new Exception("Account already exists!");
        }

        System.out.print("Enter initial balance: ");
        double bal = input.nextDouble();

        if (bal < 1000) {
            throw new Exception("Minimum balance is 1000");
        }

        accounts.put(id, new Account(id, bal));
        System.out.println("Account created successfully!");
    }

    static void deposit(Scanner input) throws Exception {
        System.out.print("Enter ID: ");
        int id = input.nextInt();

        Account acc = accounts.get(id);
        if (acc == null) throw new Exception("Account not found!");

        System.out.print("Enter amount: ");
        double amt = input.nextDouble();

        if (amt <= 0) throw new Exception("Invalid amount");

        acc.balance += amt;
        System.out.println("Deposit successful!");
    }

    static void withdraw(Scanner input) throws Exception {
        System.out.print("Enter ID: ");
        int id = input.nextInt();

        Account acc = accounts.get(id);
        if (acc == null) throw new Exception("Account not found!");

        System.out.print("Enter amount: ");
        double amt = input.nextDouble();

        if (amt <= 0) throw new Exception("Invalid amount");
        if (acc.balance < amt) throw new Exception("Insufficient balance");

        acc.balance -= amt;
        System.out.println("Withdrawal successful!");
    }

    static void checkBalance(Scanner input) throws Exception {
        System.out.print("Enter ID: ");
        int id = input.nextInt();

        Account acc = accounts.get(id);
        if (acc == null) throw new Exception("Account not found!");

        System.out.println("Current Balance: ₹" + acc.balance);
    }

    static void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(accounts);
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }

    static void loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            accounts = (HashMap<Integer, Account>) ois.readObject();
        } catch (Exception e) {
            accounts = new HashMap<>();
        }
    }
}
