import java.io.*;
import java.util.Scanner;

public class FileOperations {

    public static void main(String[] args) {
        String filePath = "example.txt"; // The file to perform operations on.

        // Step 1: Write to the file
        writeToFile(filePath, "This is the first line of the file.\nThis is the second line.");

        // Step 2: Read the file
        System.out.println("Contents of the file:");
        readFile(filePath);

        // Step 3: Modify the file by appending new text
        appendToFile(filePath, "\nThis is an appended line.");

        // Step 4: Read the updated file
        System.out.println("\nUpdated contents of the file:");
        readFile(filePath);
    }

    // Method to write text to a file
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Method to read and display the contents of a file
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Method to append text to a file
    public static void appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file: " + e.getMessage());
        }
    }
}