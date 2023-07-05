package javaPrograms.oops.Abstraction;

public class B extends A{

    //method overriding
    void show(){
        int x=5;
        int y=x*x*x;
        System.out.println("Cube of the given number is :"+y);
    }

    void accept(int x){
        if(x%2==0){
            System.out.println(x+" is a Even Number");
        }else{
            System.out.println(x+" is a Odd Number");
        }
    }

}
