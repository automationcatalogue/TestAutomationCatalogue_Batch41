package javaPrograms.oops.Inheritance_1;

public class B extends A{

    int x=20;

    void print(){
        System.out.println("Advanced Java");
    }

    public static void main(String[] args) {
        B ob2 = new B();
        ob2.show();
        System.out.println(ob2.x);
    }

    void show(){
        System.out.println(x);
    }
}
