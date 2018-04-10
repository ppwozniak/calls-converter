package pl.ppwozniak.callsimporter.models.csv;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CsvRecord {

    private String number;

    private long duration;

    private long dateAndTimeInMiliseconds;

    private int type;
}
