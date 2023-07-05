package javaPrograms.JavaFundamentals.Operators;

public class LogicalOperatorDemo {
    public static void main(String[] args) {
        int x=25, y=26, a=90, b=91;

        boolean flag = x<=y && a<=b;
                    //true && true
        System.out.println(flag);//true

        flag = x<=++y && a<=b++;

        System.out.println(flag);

        flag = ++x>=y || a>b++;
        //26>=27 || 90>92 ==> false || false
        System.out.println(flag);//false
        System.out.println("x value is :"+x+" y value is :"+y+" a value is :"+a+" b value is :"+b);//26, 27, 90, 93

    }
}

class LogicalDemo {
    public static void main(String args[]){
        int a=10, b=45, c=22;

        boolean e=((a<c) || (a>b));

        System.out.println(e);

        boolean d=((a<c) && (a>b)) && (b>c);

        System.out.println(d);

    }
}
