package javaPrograms.oops.Methods;

public class DemoK {
    int x=10;//instance variable
    public static void main(String[] args) {
        System.out.println("Hello World");

        DemoK ob1 = new DemoK();
        ob1.cube();
        ob1.checkNumber();
        System.out.println(ob1.x);
        ob1.cube();
        ob1.cube();
        //ob1.prime();
    }

    //instance method
    //method with No arguments and No return type
    //method definition
    void cube(){
        int x=5;
        int y=x*x*x;
        System.out.println("Cube of the Given number is :"+y);
    }

    void checkNumber(){
        int x=-15;
        if(x>0){
            System.out.println("Given number X is Positive "+x);
        }else if(x<=0){
            System.out.println("Given number X is Negative "+x);
        }else{
            System.out.println("Given number X is Zero");
        }
    }

}
