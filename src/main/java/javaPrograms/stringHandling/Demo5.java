package javaPrograms.stringHandling;

public class Demo5 {
    public static void main(String[] args) {
        String s1 = new String("Automation Testing learning is very essential");
        System.out.println(s1);

        boolean b=s1.contains("sagar");
        System.out.println(b);

        String s2="     Taj Mahal       ";
        System.out.println(s2);

        String s3=s2.trim();
        System.out.println(s3);
    }
}
