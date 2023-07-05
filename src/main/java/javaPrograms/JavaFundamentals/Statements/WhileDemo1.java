package javaPrograms.JavaFundamentals.Statements;

public class WhileDemo1 {
    public static void main(String[] args) {
        int x=5;
        while (x<=13){
            System.out.println("This is While Demo");
            x=x+4;
        }
        System.out.println("Value of x is :"+x);
    }
}

class WhileDemo2 {
    public static void main(String[] args) {
        int x=2;//Initializaton
        while(x<=5){
            x=20;
            System.out.println("Hello");
            System.out.println("Core Java");
            x+=3;
        }
        System.out.println("Value of x is :"+x);

    }
}

class WhileDemo3{
    public static void main(String[] args) {
        int i=1;
        while(i<=20){
            if(i<=5){
                i=i+10;
                System.out.println("Core Java and i value is :"+i);
            }else{
                System.out.println("Advanced Java and i value is :"+i);
            }
            i=i+3;
        }
        System.out.println("Final Value is of i is :"+i);
    }
}

class WhileDemo4{
    public static void main(String[] args) {
        int i=20;
        while(i>=8){
            System.out.println(i);
            i-=5;
        }
    }

}

class WhileDemo5{
    public static void main(String[] args) {
        int i=8;
        while(++i<=8){
            i=i+5;
        }
        System.out.println(i);
    }
}
