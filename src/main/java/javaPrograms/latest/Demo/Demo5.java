package javaPrograms.latest.Demo;

import java.util.Base64;

public class Demo5 {
    public static void main(String[] args) {
        String password = "Admin@123";
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        System.out.println(encodedPassword);
    }
}
