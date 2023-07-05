package javaPrograms.stringHandling;

public class Demo8 {
    public static void main(String[] args) {
        String s1="automation";
        String s2="Automation";

        boolean b=s1.equals(s2);
        System.out.println(b);

        b=s1.equalsIgnoreCase(s2);
        System.out.println(b);

    }

}
