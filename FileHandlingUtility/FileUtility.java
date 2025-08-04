package FileHandlingUtility;

import java.io.*;
import java.util.Scanner;

public class FileUtility {

    private static final String FILE_NAME = "internship_task.txt";

    public static void writeToFile() {
        String content = """
                CODTECH INTERNSHIP TASK - 1
                FILE HANDLING UTILITY
                
                INSTRUCTIONS:
                - CREATE A JAVA PROGRAM TO READ, WRITE, AND MODIFY TEXT FILES.
                - DELIVERABLE: A SCRIPT DEMONSTRATING FILE OPERATIONS WITH CLEAR DOCUMENTATION.
                
                COMPLETION CERTIFICATE WILL BE ISSUED ON YOUR INTERNSHIP END DATE.
                """;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(content);
            System.out.println("✅ File written successfully.\n");
        } catch (IOException e) {
            System.err.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    public static void readFromFile() {
        System.out.println("📖 Reading file content:");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(">> " + line);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
        }
    }

    public static void modifyFile(String oldWord, String newWord) {
        try {
            File file = new File(FILE_NAME);
            Scanner scanner = new Scanner(file);
            StringBuilder fileContent = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileContent.append(line.replaceAll(oldWord, newWord)).append(System.lineSeparator());
            }
            scanner.close();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                writer.write(fileContent.toString());
            }

            System.out.println("✏️ File modified successfully.\n");
        } catch (IOException e) {
            System.err.println("❌ Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        writeToFile();
        readFromFile();

        System.out.print("🔄 Enter the word to replace: ");
        String oldWord = sc.nextLine();
        System.out.print("🔄 Enter the new word: ");
        String newWord = sc.nextLine();

        modifyFile(oldWord, newWord);
        readFromFile();

        sc.close();
    }
}

