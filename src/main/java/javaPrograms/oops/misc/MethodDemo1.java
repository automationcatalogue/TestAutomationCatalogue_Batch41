package javaPrograms.oops.misc;

public class MethodDemo1 {

    //instance method
    //method without arguments and without return type
    void sumArray(){
        int a[]={5,9,3,6,5,2,1};
        int sum=0;
        for(int test:a){
            sum=sum+test;
        }
        System.out.println("sum of the Array numbers is :"+sum);
    }

    //instance method
    //method with arguments and with return type
    int arraySumDemo(int a[]){
        int sum=0;
        for(int x:a){
            sum=sum+x;
        }
        return sum;
    }
}
