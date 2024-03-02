import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtility {

    public static void main(String[] args) {
        String inputFilePath = /src/readfiles
        String outputFilePath = "src/csv_files/output.csv"; /

        try {
            File outputFile = new File(outputFilePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Read each file in the input directory
            File inputDirectory = new File(inputFilePath);
            for (File file : inputDirectory.listFiles()) {
                if (file.isFile()) {
                    // Process each file and write to CSV
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Process each line and write to CSV
                        writer.write(line);
                        writer.newLine(); // Add a new line after each line
                    }
                    reader.close();
                }
            }
            writer.close();
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

