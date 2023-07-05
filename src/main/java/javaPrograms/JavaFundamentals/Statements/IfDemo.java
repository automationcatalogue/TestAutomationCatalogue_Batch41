package javaPrograms.JavaFundamentals.Statements;

public class IfDemo {
    public static void main(String[] args) {
        int x=10;

        System.out.println("Before If statement");

        if(x++<11 && x==10){
            x=x+5;
            System.out.println("Value of x inside the if condition is :"+x);
        }

        System.out.println("Hello World!!");
    }

}
class IfDemo1 {
    public static void main(String[] args) {
        System.out.println("I am learning statements....");

        int x=5, y=0;
        if(x<=0){
            y=x * x* x;//5 * 5*5
            System.out.println("Cube of the given number is :"+y);
        }

        System.out.println("Value of x is: "+x+" Value of y is :"+y);
    }
}

class IfDemo2{
    public static void main(String[] args) {
        int x=40, a,b;
        char ch='A';

        int z=(x<ch)?ch:x;
        System.out.println("Before If condition, value of z is :"+z);
        boolean flag =z>=50 && x>=0;

        if(flag){

            a=10;
            b=20;
            z=a+b;
            System.out.println("Addition of the a,b is :"+z);

        }

        System.out.println("Final Value of z is :"+z);
    }
}

class IfDemo3{
    public static void main(String[] args) {
        int a=30;
        System.out.println("Hello World..!!!");

        if(false){
            System.out.println("This is a Core Java Program");
        }

        if(a==20){
            System.out.println("Value of a is :"+a);
        }

        a=200;
        boolean b=(a>=100);
        if(b){
            System.out.println("Value of a is greater than 100");
        }
    }
}

class IfDemo4{
    public static void main(String[] args) {
        int x=90,y=45,z=65;

        if((x>y) && (x==y)){
            x=78;
            System.out.println("I am in the if condition");
            System.out.println("x value is: "+x);
            System.out.println("y value is: "+y);
            System.out.println("z value is: "+z);
            y=99;
            z=100;
        }

        System.out.println("After If Statement, x value is :"+x+" y value is "+y+" z value is"+z);
    }
}


