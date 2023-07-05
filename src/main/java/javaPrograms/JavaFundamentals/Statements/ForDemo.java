package javaPrograms.JavaFundamentals.Statements;

public class ForDemo {

    public static void main(String[] args) {
        for(int i=1;i<=5;++i){
            System.out.println("Hello World!!!");

        }
    }
}

class ForDemo1 {
    public static void main(String[] args) {
        int x;

        for(x=1;x<=14;x+=5){
            System.out.println("Hello World....!!!");
        }
        System.out.println("value of x is :"+x);
    }
}

class ForDemo2{
    public static void main(String[] args) {
        int x=2;

        for(x=4;x<=10;x++){
            System.out.println("Hello World..!!!");
            ++x;
        }
        System.out.println("Value of x is :"+x);
    }
}

class ForDemo3 {
    public static void main(String[] args) {

        for(int i=20;i>=8;i=i-5){
            System.out.println(i);
        }

        int i=0;
        for(i=1;i<=20;i=i+3){
            if(i<=5){
                i=i+10;
                System.out.println("Core Java and i value is :"+i);
            }else{
                System.out.println("Advanced Java and i value is :"+i);
            }
        }
        System.out.println("Final value of i is :"+i);

    }
}

class ForDemo4{
    public static void main(String[] args) {
        for(int i=1;i<=1;i++){
            System.out.println("Hello World!!!");
        }
    }
}
