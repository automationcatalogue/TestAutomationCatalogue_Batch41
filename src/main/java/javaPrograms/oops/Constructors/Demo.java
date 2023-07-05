package javaPrograms.oops.Constructors;

import java.util.Scanner;

public class Demo {
    int x=10;

    Demo(){//default constructor
        int a=10, b=20;
        int c=a+b;
        System.out.println("Addition of a,b is :"+c);
    }

    Demo(int a){
        if(a%2==0){
            System.out.println("Even Number");
        }else{
            System.out.println("Odd Number");
        }
    }



    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n=s.nextInt();

    }
}
