package csv;
import com.opencsv.CSVWriter;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class OpenCSV {
    private static final String STRING_ARRAY_SAMPLE = "users1.csv";

    public static void main(String[] args) throws IOException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
        ) {
            String[] headerRecord = {"ID", "Nume", "Grupa", "Facultatea", "Universitateae"};
            csvWriter.writeNext(headerRecord);

            csvWriter.writeNext(new String[]{ "1723", "Alexandru Botnari", "1.2", "Biologie si Chimie", "UTM"});
            csvWriter.writeNext(new String[]{"1801", "Liliana Filipciuc", "3.2", "Economie si finante bancare", "USM" });
            csvWriter.writeNext(new String[]{ "1822", "Adelina Badea", "2.1", "TI", "USM"});
            csvWriter.writeNext(new String[]{"1717", "Alina Girlea", "1.1", "Medicina generala", "USMF" });
            csvWriter.writeNext(new String[]{"1702", "Cristina Miron", "2.3", "TI", "UTM" });

        }
    }
}
