package javaPrograms.oops.Methods;

public class DemoJ {

    public static void main() {
        int a=10, b=20;//local variables
        int c=a+b;
        System.out.println("addition of a,b is :"+c);

        DemoJ ob1 = new DemoJ();
        //method call statement
        ob1.multiply();
    }

    //Methods with No Arguments and with No return type
    //instance method
    //method definition
    void multiply(){
        int x=5, y=10;//local variables
        int z=x*y;
        System.out.println("multiplication of x,y is :"+z);
    }
}
