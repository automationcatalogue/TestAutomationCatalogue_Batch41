package javaPrograms.oops.misc;

public class DemoI {
    int a=5;
    public static void main(String[] args) {
        DemoI ob1 = new DemoI();
        --ob1.a;
        ob1.a+=5;
        System.out.println(++ob1.a);
    }
}
