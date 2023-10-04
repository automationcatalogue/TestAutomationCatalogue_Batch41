package javaPrograms.assignments.Assignment_12;

public class Demo2 {
    private int x;
    public Demo2(int a){
        x=a;
    }

    public int get_x(){
        return x;
    }

    public static void main(String[] args) {
        Demo2 ob1 = new Demo2(10);
        Demo2 ob2 = new Demo2(20);
        Demo2 ob3 =ob1;
        Demo2 ob4 =ob3;
    }
}
