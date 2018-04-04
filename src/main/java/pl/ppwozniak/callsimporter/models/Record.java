package pl.ppwozniak.callsimporter.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Record {

    @JacksonXmlProperty(isAttribute = true, localName = "number")
    private String number;

    @JacksonXmlProperty(isAttribute = true, localName = "duration")
    private int duration;

    @JacksonXmlProperty(isAttribute = true)
    private long date;

    @JacksonXmlProperty(isAttribute = true)
    private int type;

    @JacksonXmlProperty(isAttribute = true, localName = "readable_date")
    private String readableDate;

    @JacksonXmlProperty(isAttribute = true, localName = "contact_name")
    private String contactName;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Record) {
            Record r = (Record) o;
            return r.hashCode() == this.hashCode();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "Record{" +
                "number='" + number + '\'' +
                ", duration=" + duration +
                ", date=" + date +
                ", type=" + type +
                ", readableDate='" + readableDate + '\'' +
                ", contactName='" + contactName + '\'' +
                '}';
    }
}
