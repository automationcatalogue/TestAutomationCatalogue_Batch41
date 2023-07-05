package javaPrograms.oops.Inheritance_1;

public class Demo {
    public static void main(String[] args) {
        Demo ob1 = new Demo();
        ob1.test();
    }

    //instance method
    void test(){
        B ob2 = new B();
        System.out.println(ob2.x);
    }
}
