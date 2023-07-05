package javaPrograms.oops.polymorphism.MethodOerriding;

public class Test2 extends Test1{

    public void accept(int x){
        int fact=1;
        for(int i=1;i<=x;i++){
            fact =fact*i;
        }
        System.out.println("Factorial of a given number is :"+fact);
    }

    public void show(int x){
        int y=x*x*x;
        System.out.println("Cube of the given number is :"+y);
    }

}
