package pl.ppwozniak.callsconverter;

import pl.ppwozniak.callsconverter.models.csv.CsvRecord;
import pl.ppwozniak.callsconverter.models.xml.XmlRecord;
import pl.ppwozniak.callsconverter.process.CsvWriter;
import pl.ppwozniak.callsconverter.process.ObjectConverter;
import pl.ppwozniak.callsconverter.process.XmlReader;

import java.io.IOException;
import java.util.Set;

/**
 *
 */
public class Runner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Please check parameters");
        } else {
            String inputDir = args[0];
            String outputFile = args[1];

            try {
                XmlReader reader = new XmlReader();
                Set<XmlRecord> xmlRecords = reader.parseXmlFiles(inputDir);
                Set<CsvRecord> csvRecords = ObjectConverter.convertXmlRecordsToCsvRecords(xmlRecords);
                CsvWriter writer = new CsvWriter();
                writer.writeToCsvFile(csvRecords, outputFile);
            } catch (IOException exception) {
                System.err.println("Error I/O: " + exception.getMessage());
            }
        }
    }
}
