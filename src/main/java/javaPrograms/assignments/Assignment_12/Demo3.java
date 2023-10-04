package javaPrograms.assignments.Assignment_12;

public class Demo3 {
    public static void main(String[] args) {
        int a=10;
        int b=15;
        if(++a<(b=b-=4)||(a=a+=4)>b++){
            System.out.println(a+" "+b);
        }
    }
}
