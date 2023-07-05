package javaPrograms.JavaFundamentals.Statements;

public class IfElseDemo {
    public static void main(String[] args) {
        int x=-9;
        if(x>=0){
            System.out.println("Given number X is Negative");
        }else{
            System.out.println("Given number X is positive");
        }
    }
}

class IfElseDemo1 {
    public static void main(String[] args) {

        int a=-99;

        if(a>=0){//false
            a=156;
            System.out.println("a is Negative number :"+a);
        }else{
            System.out.println("a is positive number :"+a);
            a=278;
        }

        System.out.println("Final Value of a is :"+a);
    }
}

class IfelseDemo2{
    public static void main(String[] args) {
        char ch='c', ch1='c';
        int a=100;
        System.out.println("This is before Ifelse demo");
        if(ch==ch1){
            System.out.println("both character and integer values are same");
        }else{
            System.out.println("both character and integer values are not same");
        }
        System.out.println("This is after Ifelse demo");
    }
}

class IfelseDemo3{
    public static void main(String[] args) {
        int x=80, y,z;
        System.out.println("x value is :"+x);
        ++x;
        if(x++==82){
            System.out.println("value of x is 100");
        }else{
            System.out.println(x);
            System.out.println("Value of x is 900");

        }
        System.out.println("Value of x is :"+x);
    }
}

