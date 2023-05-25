package airlines.Pojos;

import lombok.Builder;
import lombok.Data;

@Data // this helps to create getter and setters methods
@Builder // this helps to create request payload.
public class Airline {
    private int id;
    private String name;
    private String country;
    private String logo;
    private String slogan;
    private String head_quaters;
    private String website;
    private String established;

}
