package pl.ppwozniak.callsconverter.process;

import pl.ppwozniak.callsconverter.models.csv.CsvRecord;
import pl.ppwozniak.callsconverter.models.xml.XmlRecord;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 *
 */
public class ObjectConverter {

    /**
     * @param xmlRecords
     * @return
     */
    public static Collection<CsvRecord> convertXmlRecordsToCsvRecords(Collection<XmlRecord> xmlRecords) {
        Collection<CsvRecord> csvRecords = new LinkedHashSet<>();

        for (XmlRecord rec : xmlRecords) {
            csvRecords.add(convertXmlRecordToCsvRecord(rec));
        }

        return csvRecords;
    }

    private static CsvRecord convertXmlRecordToCsvRecord(XmlRecord xmlRecord) {
        CsvRecord csv = new CsvRecord();

        csv.setNumber(xmlRecord.getNumber());
        csv.setDateAndTimeInMiliseconds(xmlRecord.getDate());
        csv.setDuration(xmlRecord.getDuration());
        csv.setType(xmlRecord.getType());

        return csv;
    }
}
