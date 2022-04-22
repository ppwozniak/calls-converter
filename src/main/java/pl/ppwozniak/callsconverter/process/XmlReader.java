package pl.ppwozniak.callsconverter.process;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import pl.ppwozniak.callsconverter.models.xml.XmlRecord;
import pl.ppwozniak.callsconverter.models.xml.XmlRecordRoot;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 */
public class XmlReader {

    /**
     * @param pathToDirWithXmlFiles
     * @return
     */
    public Set<XmlRecord> parseXmlFiles(String pathToDirWithXmlFiles) throws IOException {
        HashSet<XmlRecord> records = new LinkedHashSet<>();
        ObjectMapper xmlMapper = new XmlMapper();

        File dir = new File(pathToDirWithXmlFiles);
        File[] xmlFiles = dir.listFiles((dir1, name) -> name.endsWith(".xml"));

        for (File file : xmlFiles) {
            XmlRecordRoot root = xmlMapper.readValue(file, XmlRecordRoot.class);
            records.addAll(root.getCall());
        }

        return records;
    }
}
