package javaPrograms.stringHandling;

public class Demo7 {
    public static void main(String[] args) {
        String s1="Java Learning is easy and I started learning Java, Core Java and Advanced Java";
        boolean b=s1.startsWith("Learning");
        System.out.println(b);

        b=s1.endsWith("Core Java");
        System.out.println(b);

    }
}
