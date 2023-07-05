package javaPrograms.oops.Constructors;

public class Test {
    //Default constructor
    Test(){
        int x=7;
        if(x%2==0){
            System.out.println("Given number x is Even "+x);
        }else{
            System.out.println("Given number x is Odd "+x);
        }
    }

    //instance method - method with arguments and without return type
    void add(int a, int b){
        int c=a+b;
        System.out.println("Addition of a,b is :"+c);
    }

    //parameterized constructor
    Test(int a){
        int b = a*a*a;
        System.out.println("Cube of the given number is :"+b);
    }

    Test(int a, int b){
        int c=a*b;
        System.out.println("Multiplication of a,b is :"+c);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        Test ob1 = new Test();//it calls default constructor

        Test ob2 = new Test(4,9);//it calls parameterized constructor
    }
}
