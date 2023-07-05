package javaPrograms.oops.polymorphism.MethodOerriding;

public class Demo {
    public static void main(String[] args) {
        Test1 ob3 = new Test2();
        ob3.display(9);
        ob3.show(8);
    }
}
