package javaPrograms.exceptionHandling;

public class Demo12 extends Demo11{

   int y=20;

   void display(int x){
       if(x%2==0){
           System.out.println("Even Number!!!");
       }else{
           System.out.println("Odd Number!!!");
       }
   }

   void print(int x){
       int y=x*x;
       System.out.println("Square of the given number is :"+y);
   }
}
