package javaPrograms.latest.Demo;

import java.util.Base64;

public class Encoding_Decoding {
    public static void main(String[] args) {
        byte b[] = Base64.getEncoder().encode("Admin@123".getBytes());
        String encodePwd = new String(b);
        System.out.println(encodePwd);

        String decodedPassword = new String(Base64.getDecoder().decode(encodePwd.getBytes()));
        System.out.println(decodedPassword);

    }
}
