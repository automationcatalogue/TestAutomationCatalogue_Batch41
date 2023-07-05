package javaPrograms.JavaFundamentals.Statements;

public class SwitchDemo {
    public static void main(String[] args) {
        int day=3;
        switch(day){
            case 1:
                System.out.println("Monday");
                int a=10, b=20;
                int c=a+b;
                System.out.println("Sum of a,b is :"+c);
            case 2:
                System.out.println("Tuesday");
                int x=10, y=20;
                int z=x*y;
                System.out.println("Multiplicationof x,y is :"+z);
            case 3:
                System.out.println("Wednesday");
                int m=10;
                if(m>=0){
                    System.out.println("Given number is positive");
                }else{
                    System.out.println("Given number is Negative");
                }
                break;

            case 4:
                System.out.println("Thursday");
                int n=10;
                System.out.println("Given number is positive");
            case 5:
                System.out.println("Friday");
                int h=-10;
                System.out.println("Given number is Negative");

            case 6:
                System.out.println("Saturday");
                int i=-151;
                System.out.println("Given number is Negative and Odd number");
                break;
            case 7:
                System.out.println("Sunday");
                int k=158;
                System.out.println("Given number is Positive and Even number");
                break;

        }
    }
}
