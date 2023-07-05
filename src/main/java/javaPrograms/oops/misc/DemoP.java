package javaPrograms.oops.misc;

public class DemoP {
    public static void main(String[] args) {
        MethodDemo1 ob1 = new MethodDemo1();
        ob1.sumArray();

        int z[]={10,30,50,70};
        int y=ob1.arraySumDemo(z);
        System.out.println("Sum of the Array values is :"+y);
    }



}
