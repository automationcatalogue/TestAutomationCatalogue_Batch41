package javaPrograms.wrapperClasses;

public class Demo2 {
    public static void main(String[] args) {
        int x=15;
        System.out.println(x);

        String str=Integer.toHexString(x);
        System.out.println(str);

        String str1=Integer.toBinaryString(x);
        System.out.println(str1);

        String str2=Integer.toOctalString(x);
        System.out.println(str2);
    }
}
