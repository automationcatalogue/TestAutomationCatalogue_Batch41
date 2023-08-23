package javaPrograms.exceptionHandling;

public class Demo8 {
    public static void main(String[] args) {
        String s1="100";
        String s2="0";

        try{
            int x=Integer.parseInt(s1);
            int y=Integer.parseInt(s2);
            int z=x/y;
            System.out.println("Z value is :"+z);
        }catch (NumberFormatException ob1){
            System.out.println("NumberFormat Exception is occurred");
            s1=s1.substring(1);
            s2=s2.substring(1);
            int x=Integer.parseInt(s1);
            int y=Integer.parseInt(s2);
            int z=x/y;
            System.out.println("Z value is :"+z);
        }catch (ArithmeticException ob2){
            System.out.println("Please provide the second number other than Zero, default value of y is :2");
            int x=Integer.parseInt(s1);
            int y=2;
            int z=x/y;
            System.out.println("Z value is :"+z);
        }

    }
}
