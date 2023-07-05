package javaPrograms.JavaFundamentals.Operators;

public class ArithmeticDemo {
    public static void main(String[] args) {
        int a=20, b=20, d=30;
        System.out.println(a+b);

        int c=30;
        a=50;
        System.out.println(b-c);

        d=17;

        System.out.println(d);

        int e=c/6;
        System.out.println(e);

        int f=d%6;
        System.out.println(f);

        System.out.println("Core Java!!!");
    }
}

class ArithmeticDemo1{

    public static void main(String[] args) {
        int x=50, y=70, z;
        z=x+y;//Addition //120
        System.out.println("Value of z is :"+z);
        x=90;
        y=10;
        z=z+y;
        System.out.println("Value of z is :"+z);

        x=x-y;//subtraction
        System.out.println("Value of x is :"+x);

        y=z*x;//multiplication
        System.out.println("value of is :"+y);

        y=y/2;
        System.out.println("value of is :"+y);

        x=19;
        y=3;
        x=x%y;
        System.out.println("outcome of the % is :"+x);

        System.out.println(53%10);
    }


}
