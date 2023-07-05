package javaPrograms.oops.Abstraction;

abstract public class Demo1 {
    //abstract method & instance method
    abstract void print();

    abstract void display();

    //non-abstract method and instance method
    void show(){
        int x=5;
        int y=x*x*x;
        System.out.println("Cube of the given number is :"+y);
    }

}
