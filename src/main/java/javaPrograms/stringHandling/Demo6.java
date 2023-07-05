package javaPrograms.stringHandling;

public class Demo6 {
    public static void main(String[] args) {
        String s1="Java Learning is easy and I started learning Java, Core Java and Advanced Java";
        System.out.println(s1);

        String s2=s1.replaceFirst("and","but");
        System.out.println(s2);

        s2=s2.replaceAll("Java","Python");
        System.out.println(s2);
    }
}
