package pl.ppwozniak.callsimporter.process;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import pl.ppwozniak.callsimporter.models.xml.XmlRecord;
import pl.ppwozniak.callsimporter.models.xml.XmlRecordRoot;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 *
 */
public class XmlReader {

    /**
     * @param pathToDirWithXmlFiles
     * @return
     */
    public Collection<XmlRecord> parseXmlFiles(String pathToDirWithXmlFiles) {
        HashSet<XmlRecord> records = new LinkedHashSet<>();
        ObjectMapper xmlMapper = new XmlMapper();

        File dir = new File(pathToDirWithXmlFiles);
        File[] xmlFiles = dir.listFiles((dir1, name) -> name.endsWith(".xml"));

        for (File file : xmlFiles) {
            try {
                XmlRecordRoot root = xmlMapper.readValue(file, XmlRecordRoot.class);

                for (XmlRecord rec : root.getCall()) {
                    records.add(rec);
                }

            } catch (IOException ex) {
                System.err.println("File '" + file.getAbsolutePath() + "' is bad!");
                ex.printStackTrace();
            }
        }

        return records;
    }
}
