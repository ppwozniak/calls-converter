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
     * @throws IOException
     */
    public void writeToCsvFile(Collection<CsvRecord> records, String outputFilePath) {
        try {
            FileWriter fileWriter = new FileWriter(outputFilePath);
            CSVPrinter printer = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("number", "duration", "type",
                    "miliseconds"));

            for (CsvRecord rec : records) {
                printer.printRecord(rec.getNumber(), rec.getDuration(), rec.getType(), rec.getDateAndTimeInMiliseconds());
            }

            printer.flush();
            printer.close();
            fileWriter.close();
        } catch (IOException ex) {
            System.err.println("Error with output file!!");
            ex.printStackTrace();
        }
    }
}
