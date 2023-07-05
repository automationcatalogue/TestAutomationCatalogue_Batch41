package javaPrograms.assignments.misc;

import java.util.Scanner;

public class EvenDemo {
    public static void main(String[] args) {

        System.out.println("This is Even off demo program");
        Scanner s = new Scanner(System.in);
        int j = s.nextInt();

        for(;j<=20;j++){
            if(j%2==0){
                System.out.println(j);
            }
        }

    }
}
