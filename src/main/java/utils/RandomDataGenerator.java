package utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {
    public static Faker faker = new Faker();

    public static String getFirstName(){
        return faker.name().firstName();
    }

    public static String getRandomDataFor(RandomDataTypeNames dataTypeNames){
        switch (dataTypeNames) {
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
            case FULLNAME:
                return faker.name().fullName();
            case COUNTRY:
                return faker.country().name();
            case CITYNAME:
                return faker.address().city();
            default:
                return "";
        }
    }

    public static String getRandomNumber(int count){
        return faker.number().digits(count);
    }

    public static String getRandomAlphabate(int size){
        return RandomStringUtils.randomAlphabetic(size);
    }

    public static String getRandomNumber(int min, int max){
        return String.valueOf(faker.number().numberBetween(min, max));
    }

    public static String getRandomWebiste(){
        return ("https://"+RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME)+RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME)+".com");
    }
}
