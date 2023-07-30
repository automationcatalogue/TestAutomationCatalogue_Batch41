package javaPrograms.latest.Demo;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Demo4 {
    public static void main(String[] args) {
        String test = RandomStringUtils.randomNumeric(4);
        System.out.println(test);

        test = RandomStringUtils.randomAlphabetic(4);
        System.out.println(test);

        Faker ob = new Faker();
        String data = ob.address().country();
        System.out.println(data);

        String randomNumber = RandomStringUtils.randomNumeric(6);
        System.out.println(randomNumber);

        String number = RandomStringUtils.randomNumeric(1,50);
        System.out.println(number);

        Random random = new Random();
        int n = random.nextInt(50);
        System.out.println(n);

    }
}
