package javaPrograms.assignments.misc;

public class DemoE {
    public static void main(String[] args) {
        TriangleDemo_ClassVariable.a = TriangleDemo_ClassVariable.b +TriangleDemo_ClassVariable.c;
        System.out.println(TriangleDemo_ClassVariable.a);

        AvgDemo_Instance ob1 = new AvgDemo_Instance();
        double total =ob1.maths+ob1.sc;
        System.out.println(total);
    }
}
