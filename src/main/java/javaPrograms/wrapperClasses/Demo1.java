package javaPrograms.wrapperClasses;

public class Demo1 {
    public static void main(String[] args) {

        //Auto boxing
        int x=99;
        Integer ob1 = new Integer(x);
        System.out.println(ob1);

        //Auto Unboxing
        Integer ob2 = new Integer(500);
        int y=ob2.intValue();
        System.out.println(y);
    }
}
