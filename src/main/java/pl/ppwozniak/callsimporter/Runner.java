package pl.ppwozniak.callsimporter;

import pl.ppwozniak.callsimporter.models.csv.CsvRecord;
import pl.ppwozniak.callsimporter.models.xml.XmlRecord;
import pl.ppwozniak.callsimporter.process.CsvWriter;
import pl.ppwozniak.callsimporter.process.ObjectConverter;
import pl.ppwozniak.callsimporter.process.XmlReader;

import java.util.Collection;

/**
 *
 */
public class Runner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String inputDir = args[0];
        String outputFile = args[1];

        XmlReader reader = new XmlReader();
        Collection<XmlRecord> xmlRecords = reader.parseXmlFiles(inputDir);
        Collection<CsvRecord> csvRecords = ObjectConverter.convertXmlRecordsToCsvRecords(xmlRecords);
        CsvWriter writer = new CsvWriter();
        writer.writeToCsvFile(csvRecords, outputFile);
    }
}
