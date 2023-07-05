package javaPrograms.oops.misc;

public class DemoH {
    int x;//instance variable
    static boolean f;//class variable

    public static void main(String[] args) {
        int c;//local variable

        DemoH ob1 = new DemoH();
        System.out.println(ob1.x);
        //c=20;
        System.out.println(DemoH.f);

        //System.out.println(c);
    }
}
