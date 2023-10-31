package javaPrograms.assignments.Assignment_12;

public class Demo4 {
    public static void main(String[] args) {
        int year = 2024;
        boolean b = ((year%4==0)&&(year%100!=0))|| (year%400==0);
        System.out.println(b);
    }
}
