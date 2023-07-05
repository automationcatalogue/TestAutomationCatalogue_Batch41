package javaPrograms.oops.misc;


public class VariableDemo {
    int x=10;//Instance variable

    static int y =20;//class variable

    public static void main(String[] args) {
        int z=30;//Local variable
        System.out.println(z);
    }

    void accept(){
        int i =90;//Local variable
        System.out.println(i);
    }

    static{
        int c=40;
        System.out.println(c);
    }

}
