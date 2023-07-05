package javaPrograms.JavaFundamentals.Operators;

public class RelationalDemo {
    public static void main(String[] args) {
        int a=10, b=20;
        System.out.println(a>b);//false

        boolean c = (a<=b);
        System.out.println(c);//true

        a=20;
        boolean d = (a!=b);
        System.out.println(d);
    }
}

class RelationalDemo1 {
    public static void main(String[] args) {
        int x=20, y=20;
        boolean z=x>y;

        System.out.println(z);
        System.out.println(x<y);
        System.out.println(x<=y);
        System.out.println(x>=y);
        System.out.println(x!=y);
        System.out.println(x==y);
    }
}

class RelationalDemo2 {

    public static void main(String[] args) {

        int x=40, y=50;

        boolean z=x>y;
        System.out.println("value of z is :"+z);

        System.out.println(x<y);

        boolean a= y<=100;
        System.out.println("Value of a is :"+a);

        boolean b = (20>=x);
        System.out.println("Value of b is :"+b);

        System.out.println(x==y);
        System.out.println(40==x);

        System.out.println(y!=50);
        System.out.println(x!=y);


    }
}

