package utilities;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class RandomGenerator {
    public static String getRandomData(String typeOfData) {
        Faker ob = new Faker();
        String data = "";
        if (typeOfData.equalsIgnoreCase("firstName")) {
            data = ob.name().firstName();
        } else if (typeOfData.equalsIgnoreCase("lastName")) {
            data = ob.name().lastName();
        } else if (typeOfData.equalsIgnoreCase("fullName")) {
            data = ob.name().fullName();
        } else if (typeOfData.equalsIgnoreCase("userName")) {
            data = ob.name().username();
        } else if (typeOfData.equalsIgnoreCase("company")) {
            data = ob.company().name();
        } else if (typeOfData.equalsIgnoreCase("country")) {
            data = ob.address().country();
        } else if (typeOfData.equalsIgnoreCase("city")) {
            data = ob.address().city();
        } else if (typeOfData.equalsIgnoreCase("address1")) {
            data = ob.address().buildingNumber();
        } else if (typeOfData.equalsIgnoreCase("address2")) {
            data = ob.address().streetAddress();
        } else if (typeOfData.equalsIgnoreCase("zipcode")) {
            data = ob.address().countryCode();
        } else if (typeOfData.equalsIgnoreCase("phoneNumber")) {
            data = ob.phoneNumber().cellPhone();
        }
        return data;
    }

    public static String getRandomEmail(int length) {
        String email = RandomStringUtils.randomAlphabetic(length) + "@test.org";
        return email;
    }

    public static String getRandomNumeric(int range) {
        String randomNumber = RandomStringUtils.randomNumeric(range);
        return randomNumber;
    }

    public static int getRandomNumberInRange(int max) {
        Random random = new Random();
        int number = random.nextInt(max);
        return number;
    }

}
