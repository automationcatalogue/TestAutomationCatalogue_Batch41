package javaPrograms.stringHandling;

public class Demo1 {

    public static void main(String[] args) {
        String ob1 = "TestABCD";
        System.out.println(ob1);

        String s=ob1.toLowerCase();
        System.out.println(s);

        String s2=ob1.toUpperCase();
        System.out.println(s2);

        s2=ob1.replace('o','z');
        System.out.println(s2);

        String s3 = ob1.replace("tion","sarika");
        System.out.println(s3);

    }
}
