package javaPrograms.oops.Methods;

public class DemoN {

    //instance method
    //method without arguments and with return type
    //method definition
    int checkNumber(){
        int a=10, b=20;
        int c=a+b;

        float x=9.23f, y=5.34f;
        float z=x+y;


        return 112;
    }

    void evenOdd(int a){
        if(a%2==0){
            System.out.println("Given number is Even "+a);
        }else{
            System.out.println("Given number is Odd "+a);
        }
    }


    public static void main(String[] args) {
        DemoN ob1 = new DemoN();
        //method call statement
        int x=ob1.checkNumber();

        ob1.evenOdd(x);


    }
}
