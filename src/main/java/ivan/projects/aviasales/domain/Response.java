package ivan.projects.aviasales.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    public String departureTime;
    public String arrivalTime;
    public String number;
}
