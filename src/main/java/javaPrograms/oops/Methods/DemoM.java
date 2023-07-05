package javaPrograms.oops.Methods;

public class DemoM {

    void evenOdd(int x){

        if(x%2==0){
            System.out.println("Given number X is Even "+x);
        }else{
            System.out.println("Given number X is Odd "+x);
        }
    }

    static void primeDemo(){
        int x=11;
        int count=0;
        for(int i=1;i<=x;i++){
            if(x%i==0){
                count++;
            }
        }
        if(count==2){
            System.out.println("Given number x is Prime number :"+x);
        }else{
            System.out.println("Given number x is not Prime number :"+x);
        }
    }

    void multiply(){
        int x=5, y=10;//local variables
        int z=x*y;
        System.out.println("multiplication of x,y is :"+z);
    }

    void m1(int x, float y, boolean b){

        evenOdd(x);
        x--;
        System.out.println("Value of x is :"+ (--x));

        y=y+10.5f;
        System.out.println("Latest Value of y is :"+y);

        evenOdd(x);
        DemoM.primeDemo();

        if(b){
            System.out.println("CoreJava");
        }else{
            System.out.println("AdvancedJava");
        }
    }

    public static void main(String[] args) {
        DemoM ob1 = new DemoM();

        ob1.multiply();
        //ob1.evenOdd(8.9f);
        //ob1.m1(48,5.96f, true);
    }

}
