package javaPrograms.oops.misc;

public class DemoF {
    int x=5;//instance variable
    static int y=10;//class variable

    public static void main(String[] args) {
        DemoF ob1 = new DemoF();
        DemoF ob2 = new DemoF();

        ob1.x = ob1.x+2;
        ob1.y = ob1.y+2;

        System.out.println(ob1.x);//7
        System.out.println(ob1.y);//12
        System.out.println(ob2.x);//5
        System.out.println(ob2.y);//12
    }
}
