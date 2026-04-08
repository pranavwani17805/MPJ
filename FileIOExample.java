package polymorphism;

import java.io.*;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filePath = "test.txt";

        try {
            PrintStream originalOut = System.out;
            PrintStream fileStream = new PrintStream(new FileOutputStream(filePath, true));

            System.out.println("\n=== Banking System ===");
            System.out.println("1. Open New Account");
            System.out.println("2. Quit");
            originalOut.print("Select option: ");
            int option = input.nextInt();

            if (option == 1) {
                originalOut.print("Enter Customer ID (1-20): ");
                int id = input.nextInt();

                if (id < 1 || id > 20) {
                    throw new Exception("Customer ID must be between 1 and 20.");
                }

                originalOut.print("Enter Deposit Amount: ");
                double deposit = input.nextDouble();

                if (deposit < 1000) {
                    throw new Exception("Initial deposit must be at least Rs. 1000.");
                }

                // Redirect output to file
                System.setOut(fileStream);

                System.out.println("ID: " + id);
                System.out.println("Amount Deposited: " + deposit);
                System.out.println("Account Created Successfully");
                System.out.println("============================");

                // Restore console output
                System.setOut(originalOut);
                System.out.println("Record stored in " + filePath);
            }

            fileStream.close();

            System.out.print("\nView saved data? (yes/no): ");
            String response = input.next();

            if (response.equalsIgnoreCase("yes")) {
                File file = new File(filePath);
                Scanner reader = new Scanner(file);

                System.out.println("\n=== File Contents ===");
                while (reader.hasNextLine()) {
                    System.out.println(reader.nextLine());
                }
                reader.close();
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        input.close();
    }
}
