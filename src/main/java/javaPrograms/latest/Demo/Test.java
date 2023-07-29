package javaPrograms.latest.Demo;

public class Test {
    public static void main(String[] args) {
        Demo ob1 = new Demo();
        ob1.evenOdd();
        Demo.cube();

        Demo1 ob2 = new Demo1();
        ob2.add(10,20,30);
        Demo1.prime(11);

        Demo2 ob3 = new Demo2();
        int z= ob3.fact();
        System.out.println(z);
        float a=Demo2.square();

        Demo3 ob4 = new Demo3();
        int y=ob4.cube(6);
        int u=Demo3.mul(10,20);

    }
}
