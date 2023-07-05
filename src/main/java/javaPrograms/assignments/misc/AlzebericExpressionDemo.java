package javaPrograms.assignments.misc;

import java.util.Scanner;

public class AlzebericExpressionDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of a, b, x");
        double a = s.nextDouble();
        double b = s.nextDouble();
        double x = s.nextDouble();

        double z = (a*x+b)/(a*x-b);
        System.out.println("Alzebric Expression output is :"+z);
    }

}
