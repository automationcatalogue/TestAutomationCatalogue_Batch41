package javaPrograms.assignments.misc;

public class AvgDemo_Instance {
    double en =90, maths = 95, sc=65, so =74, Hindi = 86;//instance variables
    double avg;//instance variable



    public static void main(String[] args) {

        AvgDemo_Instance ob1 = new AvgDemo_Instance();

        ob1.avg = (ob1.en+ob1.maths+ob1.sc+ob1.so+ob1.Hindi)/5;
        System.out.println("Average Marks of the student is :"+ob1.avg);

        if(ob1.avg>=70){
            System.out.println("Student is passed with First Class Distinction "+ob1.avg);
        }else if(ob1.avg>=60 && ob1.avg<70){
            System.out.println("Student is passed with First Class "+ob1.avg);
        }else if(ob1.avg>=50 && ob1.avg<60){
            System.out.println("Student is passed with Second Class "+ob1.avg);
        }else if(ob1.avg>=40 && ob1.avg<50){
            System.out.println("Sudent is passed with Third Class "+ob1.avg);
        }else{
            System.out.println("Student is Failed "+ob1.avg);
        }
    }
}
