package FileHandlingUtility;

import java.io.*;
import java.util.Scanner;

public class FileUtility {

    private static final String FILE_NAME = "football_worldcup.txt";

    public static void writeToFile() {
        String content = """
                FIFA FOOTBALL WORLD CUP OVERVIEW

                ABOUT:
                The FIFA World Cup is the most prestigious football tournament in the world, held every 4 years.
                It features national teams from across the globe competing for the ultimate prize in international football.

                HISTORY:
                - First held in 1930 in Uruguay.
                - Brazil has won the most titles (5).
                - The 2022 World Cup was held in Qatar and won by Argentina.

                FORMAT:
                - 32 teams compete in a month-long tournament.
                - Group stage followed by knockout rounds.
                - Final match determines the world champion.

                FUN FACTS:
                - The World Cup trophy is made of 18-karat gold.
                - It is estimated that over 1 billion people watched the 2018 final.

                ⚽ Stay tuned for the next edition of the World Cup!
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
