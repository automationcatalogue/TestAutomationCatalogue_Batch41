package javaPrograms.oops.FinalAndAccessModifiers;

public class Demo1 {
    final int x;

    Demo1(){
        x=10;
    }

    public static void main(String[] args) {
        Demo1 ob1 = new Demo1();
        System.out.println(ob1.x);
    }
}
