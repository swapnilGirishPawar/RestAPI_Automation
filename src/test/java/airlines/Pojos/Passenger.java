package airlines.Pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Passenger {
    private String name = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    private int trips = Integer.parseInt(RandomDataGenerator.getRandomNumber(2));
    private int airline = Integer.parseInt(RandomDataGenerator.getRandomNumber(1));
}
