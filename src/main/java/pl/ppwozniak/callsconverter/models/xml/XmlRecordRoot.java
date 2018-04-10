package pl.ppwozniak.callsconverter.models.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JacksonXmlRootElement(localName = "calls")
@Getter
@Setter
public class XmlRecordRoot {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<XmlRecord> call;

    @JacksonXmlProperty(isAttribute = true)
    private int count;
}
