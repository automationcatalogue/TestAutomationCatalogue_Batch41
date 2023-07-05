package javaPrograms.oops.misc;

public class DemoB {
    int j = 99;//instance variable

    public static void main(String[] args) {
        int i = 55;//local variable
        System.out.println(i);

        DemoB ob1 = new DemoB();
        System.out.println(ob1.j);//through object reference

        System.out.println(new DemoB().j);//through object

    }
}
