package javaPrograms.latest.Demo;

public class Demo {
    //instance method
    //method without return type and with arguments
    void evenOdd(){
        int x=10;
        if(x%2==0){
            System.out.println("Given number is Even!!!");
        }else{
            System.out.println("Given number is Odd!!!");
        }
    }

    //class method
    //method without return type and with arguments
    static void cube(){
        int x=5;
        int y=x*x*x;
        System.out.println("Cube of the given number is :"+y);
    }
}
