package pl.ppwozniak.callsconverter.process;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import pl.ppwozniak.callsconverter.models.csv.CsvRecord;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 *
 */
public class CsvWriter {

    /**
     * @param records
     * @param outputFilePath
     */
    public void writeToCsvFile(Collection<CsvRecord> records, String outputFilePath) throws IOException {
        FileWriter fileWriter = new FileWriter(outputFilePath);
        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader("number", "duration", "type", "miliseconds").build();
        CSVPrinter printer = new CSVPrinter(fileWriter, format);

        for (CsvRecord rec : records) {
            printer.printRecord(rec.getNumber(), rec.getDuration(), rec.getType(), rec.getDateAndTimeInMiliseconds());
        }

        printer.flush();
        printer.close();
        fileWriter.close();
    }
}
