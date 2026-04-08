import java.io.*;

public class FileIOExample {

    public static void main(String[] args) {

        // Writing to a file
        try {
            FileWriter writer = new FileWriter("sample.txt");
            writer.write("Hello, this is a File I/O example in Java.\n");
            writer.write("Exception handling is important!");
            writer.close();

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }

        // Reading from a file
        try {
            FileReader reader = new FileReader("sample.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;
            System.out.println("\nReading data from file:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }

        // Demonstrating finally block
        try {
            int result = 10 / 0;  // This will cause ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("\nArithmetic Exception occurred: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed (cleanup code).");
        }
    }
}