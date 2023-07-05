package javaPrograms.oops.Abstraction1;

public class C implements A{
    public void show(){
        int fact =1;
        for(int n=6;n>=1;n--){
            fact =fact*n;
        }
        System.out.println("Factorial of a given number is :"+fact);
    }
}
