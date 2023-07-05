package javaPrograms.assignments.misc;

public class LeapYearDemo {
    public static void main(String[] args) {
        int year =2022;
        if(year%4==0){
            System.out.println("Given year is Leap Year "+year);
        }else{
            System.out.println("Given year is Non Leap Year "+year);
        }
    }
}
