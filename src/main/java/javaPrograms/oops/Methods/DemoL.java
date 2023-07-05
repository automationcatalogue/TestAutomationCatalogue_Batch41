package javaPrograms.oops.Methods;

public class DemoL {

    //Instance method
    //method with arguments and No return type
    //method definition
    void m1(int x, float y, boolean b){
        x--;
        System.out.println("Value of x is :"+ (--x));

        y=y+10.5f;
        System.out.println("Latest Value of y is :"+y);

        if(b){
            System.out.println("CoreJava");
        }else{
            System.out.println("AdvancedJava");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!!");

        DemoL ob1 = new DemoL();
        ob1.m1(56, 5.23f, false);
        ob1.m1(89, 4.69f, true);
    }
}
