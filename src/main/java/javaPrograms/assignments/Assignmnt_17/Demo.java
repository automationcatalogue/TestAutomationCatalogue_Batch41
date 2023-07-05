package javaPrograms.assignments.Assignmnt_17;

public class Demo {
    public static void main(String[] args) {
        int x[]={12,15,16,20};
        C ob1 = new C(x);

        System.out.println(ob1.x);
        System.out.println(A.y);
        int z=ob1.addNumbers(10,20);
        System.out.println("Sum of the numbers is z :"+z);
        boolean data = A.evenOdd();
        if(data){
            System.out.println("Even number");
        }else{
            System.out.println("Odd number");
        }

        System.out.println(ob1.ch);
        System.out.println(ob1.m);
        ob1.primeDemo(9);
        ob1.sumOfEvenNumbers();


        System.out.println(ob1.g);
        System.out.println(ob1.h);
        ob1.checkNumber(-55);
        ob1.compareNumbers(12,9);
    }
}
