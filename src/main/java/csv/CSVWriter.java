package csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Arrays;

public class CSVWriter {
    private static final String SAMPLE_CSV_FILE = "users.csv";

    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(SAMPLE_CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Nume", "Grupa", "Facultate", "Universitate"));
        ) {
            csvPrinter.printRecord("1723", "Alexandru Botnari", "1.2", "Biologie si Chimie", "UTM" );
            csvPrinter.printRecord("1801", "Liliana Filipciuc", "3.2", "Economie si finante bancare", "USM");
            csvPrinter.printRecord("1822", "Adelina Badea", "2.1", "TI", "USM");
            csvPrinter.printRecord("1717", "Alina Girlea", "1.1", "Medicina generala", "USMF");
            csvPrinter.printRecord("1702", "Cristina Miron", "2.3", "TI", "UTM");

            csvPrinter.flush();
        }
    }
}
