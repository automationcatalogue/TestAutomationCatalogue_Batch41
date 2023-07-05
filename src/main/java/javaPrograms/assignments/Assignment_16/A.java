package javaPrograms.assignments.Assignment_16;

public class A {

    int test=99;//instance variable

    //instance method
    //method with arguments and with return type
    int factDemo(int n){
        int fact=1;

        for(int i=n;i>=1;i--){
            fact = fact*i;
        }
        return fact;
    }
}
