package javaPrograms.assignments.Assignment_12;

import java.util.Scanner;
//commented
public class Demo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value for n");
        int n = s.nextInt();

        int a=Sample4.checkPrime(n);

        Sample1 ob1 = new Sample1();
        ob1.checkArmStrong(a);

        Sample2 ob2 = new Sample2();
        int b=ob2.addNumbers();
        System.out.println("Sum of the Numbers is :"+b);

        Sample3 ob3 = new Sample3();
        ob3.checkLetter();

    }

}
