package javaPrograms.oops.misc;

public class DemoC {

    int x=17;//instance variable

    public static void main(String[] args) {

        DemoC ob1 = new DemoC();

        if(ob1.x%2==0){
            System.out.println(ob1.x+" is a Even Number");
        }else{
            System.out.println(ob1.x+ " is a Odd Number");
        }

    }
}
