package javaPrograms.JavaFundamentals.Operators;

public class IncrementDecrementOperator {

    public static void main(String[] args) {
        int x=5, y=5,z=5, a=5;

        ++x;//Pre-Increment (x=x+1)
        System.out.println("Value of x is :"+x);//6

        y++;//Post-Increment (y=y+1)
        System.out.println("Value of y is :"+y);//6

        --z;//Pre-Decrement (z=z-1)
        System.out.println("Value of z is :"+z);//4

        a--; //Post-Decrement (a=a-1)
        System.out.println("Value of a is :"+a);//4

    }



}

class IncrementDecrementOperators1{
    public static void main(String[] args) {
        int x=10;
        ++x;
        System.out.println("x value is :"+x);

        x++;//(x=x+1)
        System.out.println("x value is :"+x);

        --x;//(x-1)
        System.out.println("x value is :"+x);

        x--; //(x-1)
        System.out.println("X value is :"+x);
    }
}

class IncrementDecrementOperators2{
    public static void main(String[] args) {
        int x=5, y=5, z=5,a=5;
        System.out.println("x value is :"+ (++x));//6

        System.out.println("y value is :"+(y++));//5
        System.out.println(y);

        System.out.println("z value is :"+(--z));//4

        System.out.println("a value is :"+(a--));//5
        System.out.println(a);

    }
}

class IncrementDecrementOperators3{
    public static void main(String[] args) {
        int x=5, y=5, z=5,a=5;
        System.out.println("x value is :"+ (++x));//6

        System.out.println("y value is :"+(y++));//5
        System.out.println(y);

        System.out.println("z value is :"+(--z));//4

        System.out.println("a value is :"+(a--));//5
        System.out.println(a);

    }
}

class UnaryDemo2 {
    public static void main(String[] args) {
        int a=45;
        int b=a-- + a--; //(a=a-1)
        //45 (44) + 44 (43)

        System.out.println("b= "+ b);//45
        System.out.println("a= "+ a);//44

        int x=5;
        int y=(x++) + (++x) + (--x);
        //5 (6) + 7 (7) + 6 (6) ==> 5+7+6 ==>18


        System.out.println("x= "+x);//6
        System.out.println("y= "+y);//18

        int i=5;

        i=(i--) + (++i) + (i--) + (--i) + (++i) + (++i) + (i--);
        //5 (4) + +5 (5) +  5 (4) + 3 (3) + 4 (4) + 5 (5) + 5 (4)
        // ==> 5+5+5+3+4+5 + 5

        System.out.println(i);//32

    }
}


