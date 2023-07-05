package javaPrograms.assignments.misc;

public class SumDemo {
    public static void main(String[] args) {

        int n=15;
        int i=1;
        int sum=0;

        while(i<=n){
            sum=sum+i;
            i++;
        }
        System.out.println("Sum of the "+n+" numbers is :"+sum);

    }
}
