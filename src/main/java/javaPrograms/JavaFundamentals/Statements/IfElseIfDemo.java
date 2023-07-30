package javaPrograms.JavaFundamentals.Statements;

public class IfElseIfDemo {
    public static void main(String[] args) {
        int x=90, y=75;
        int z=x+y;

        if(x>=80 && z<=50){
            y=4;
            int a=y*y;
            System.out.println("Square of the number is :"+a);
        }else if(x!=90 || z>=50){
            x=8;
            z=x+y;
            System.out.println("Addition of x, y is :"+z);
        }else if(x==90 && y==75){
            z=y-x;
            System.out.println("Subtraction of x,y is  :"+z);
        }else{
            System.out.println("I am learing Ifelse if Demo");
        }

        System.out.println("Value of x is :"+x+" Value of y is :"+y+" value of z is :"+z);
    }
}

class IfelseifDemo1 {
    public static void main(String[] args) {
        int x='F';//70
        if(x>=80){
            x+=100;
        }else if(x%2==0){
            x=x-10;
        }else if(x>=50){
            x-=90;
        }else if(x<=0){
            x=x*x;
        }else{
            x++;
        }
        System.out.println("Value of x is :"+x);
    }
}

class IfelseifDemo2{
    public static void main(String[] args) {
        int a=99, b=87, c=121;
        System.out.println("Sagar");

        if(a<=b || a==c){
            System.out.println("Core Java");
        }else if(a!=b && c<a){
            System.out.println("Advanced Java");
        }else if(a>=25 && (a<=99 || c>=500)){
            System.out.println("Python");
        }else{
            System.out.println("Batch41..!!!");
        }
    }
}
