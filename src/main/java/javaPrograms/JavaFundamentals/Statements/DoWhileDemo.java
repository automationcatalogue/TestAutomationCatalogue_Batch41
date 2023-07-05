package javaPrograms.JavaFundamentals.Statements;

public class DoWhileDemo{
    public static void main(String[] args) {
        int i=1;
        do{
            System.out.println("Hello World");
            ++i;
        }while(i<=5);
    }
}

class DoWhileDemo1 {
    public static void main(String[] args) {
        int x=10;
        do{
            System.out.println("Hello World..!!!");
            if(x==30){
                x=90;
            }
            x=x+10;
        }while(x<=100);

        System.out.println("Loop programming..!!! and value of x is :"+x);
    }
}

class DoWhileDemo2{
    public static void main(String[] args) {
        int i=8;
        do{
            i=i+5;
        }while(++i<=8);
        System.out.println(i);
    }
}