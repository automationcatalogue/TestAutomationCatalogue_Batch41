package javaPrograms.assignments.Assignment_18;

public class Demo {
    public static void main(String[] args) {
        A ob1 = new A();
        System.out.println(ob1.x);
        ob1.cube(5);
        //System.out.println(ob1.y);
        //ob1.evenOdd(5);

        B ob2 = new B();
        System.out.println(ob2.x);
        ob2.cube(5);
        System.out.println(ob2.y);
        ob2.evenOdd(5);


        A ob3 = new B();
        System.out.println(ob3.x);
        ob3.cube(5);
        //System.out.println(ob3.y);
        //ob3.evenOdd(5);

       // B ob4 = new A();

    }
}
