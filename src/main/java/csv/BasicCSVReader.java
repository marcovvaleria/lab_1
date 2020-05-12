package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class BasicCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "users.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = new BufferedReader(new FileReader(SAMPLE_CSV_FILE_PATH));
                       // Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String id = csvRecord.get(0);
                String nume = csvRecord.get(1);
                String grupa = csvRecord.get(2);
                String facultatea = csvRecord.get(3);
                String universitatea = csvRecord.get(4);

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("ID : " + id);
                System.out.println("Nume : " + nume);
                System.out.println("Grupa : " + grupa);
                System.out.println("Facultatea : " + facultatea);
                System.out.println("Universitatea : " + universitatea);
                System.out.println("---------------\n\n");
            }
        }
    }
}
