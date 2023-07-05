package javaPrograms.assignments.misc;

import java.util.Scanner;

public class ArmStrongDemo {

    public static void main(String[] args) {
       int n=153;
        int temp =n;

        int sum = 0;

        while(n!=0){
            int r = n%10;
            sum = sum+(r*r*r);
            n=n/10;
        }

        if(temp==sum){
            System.out.println("Given number is Armstrong number :"+temp);
        }else{
            System.out.println("Given number is not Armstrong number :"+temp);
        }
    }

}

class ArmStrongDemo1{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n= s.nextInt();
        int sum=0;
        int temp=n;

        for(;n!=0;){
            int r=n%10;
            sum=sum+(r*r*r);
            n=n/10;
        }

        if(sum==temp){
            System.out.println("Given number is Armstrong number "+temp);
        }else{
            System.out.println("Given number is not Armstrong number "+temp);
        }


    }
}

