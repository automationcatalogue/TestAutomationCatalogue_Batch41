package javaPrograms.wrapperClasses;

public class Demo {

    Demo(int a){//Parameterized
        System.out.println("Hello India");
    }

    int y=20;//instance variable

    void cube(){//instance method
        int x=5;
        int y=x*x*x;
        System.out.println("Cube of the number is :"+y);
    }

    public static void main(String[] args) {

        Demo ob1 = new Demo(10);

    }
}
