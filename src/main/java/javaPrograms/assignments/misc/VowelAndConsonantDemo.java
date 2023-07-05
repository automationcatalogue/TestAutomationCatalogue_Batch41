package javaPrograms.assignments.misc;

import java.util.Scanner;

public class VowelAndConsonantDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value for a character");
        char ch='T';
        if(ch=='A'|| ch=='E' || ch=='I'||ch=='O'||ch=='U'){
            System.out.println("Given character is Vowel: "+ch);
        }else{
            System.out.println("Given Character is Consonant: "+ch);
        }
    }
}
