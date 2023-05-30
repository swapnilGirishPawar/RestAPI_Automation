package airlines.Pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

import java.util.stream.Stream;

@Data // this helps to create getter and setters methods
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder // this helps to create request payload.
public class Airline {
    private int id = Integer.parseInt(RandomDataGenerator.getRandomNumber(8));
    private String name = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    private String country = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY);
    private String logo = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FULLNAME);
    private String slogan = RandomDataGenerator.getRandomAlphabate(20);
    private String head_quaters = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME);
    private String website = RandomDataGenerator.getRandomWebiste();
    private String established = RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear());
}
