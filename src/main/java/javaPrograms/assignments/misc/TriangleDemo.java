package javaPrograms.assignments.misc;

import java.util.Scanner;

public class TriangleDemo {
    public static void main(String[] args) {
        int a,b,c;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Value for a");
        a = s.nextInt();
        System.out.println("Enter the value for b");
        b = s.nextInt();
        System.out.println("Enter the value for c");
        c=s.nextInt();

        if(a==b && b==c){
            System.out.println("Given a,b,c are Equilateral triangle");
        }else if(a==b || b==c || c==a){
            System.out.println("Given a,b,c are Bilateral triangle");
            if(a==b){
                System.out.println("a&b are same for Bilteral triangle");
            }else if(b==c){
                System.out.println("b&c are same for Bilteral triangle");
            }else if(c==a){
                System.out.println("c&a are same for Bilteral triangle");
            }
        }else if(a!=b && b!=c && c!=a){
            System.out.println("Given a,b,c are Scalen triangle");
        }
    }

}

class NestedIfDemo1 {
    public static void main(String[] args) {
        int n=84;
        
        if(n%2==0){
            System.out.println("EvenNumber");
            if(n>=80){
                System.out.println("Distinction");
                n=-25;
                if(n>=0){
                    System.out.println("PositiveNumber");
                }else{
                    System.out.println("NegativeNumber");
                }
            }else if(n>=50 && n<70){
                System.out.println("FirstClass");
            }else{
                System.out.println("Fail");
            }

        }else{
            System.out.println("OddNumber");
            if(n==70){
                System.out.println("Core Java");
            }else if(n==60){
                System.out.println("Advanced Java");
            }else{
                System.out.println("Java programming");
            }
        }
    }
}
