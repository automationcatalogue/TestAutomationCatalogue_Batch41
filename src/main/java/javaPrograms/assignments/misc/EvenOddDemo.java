package javaPrograms.assignments.misc;

import java.util.Scanner;

public class EvenOddDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of x ");
        int x = s.nextInt();
        if(x%2==0){
            System.out.println("Given number x is Even "+x);
        }else{
            System.out.println("Given number x is Odd "+x);
        }
    }
}
