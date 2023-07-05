package javaPrograms.oops.misc;

public class EnhancedForDemo {
    public static void main(String[] args) {
        int a[]={72,45,500,68,95,85,-76, -34};

        for(int b:a){
            if(b%2==0){
                System.out.println("Even number :"+b);
            }else{
                System.out.println("Odd number :"+b);
            }

        }
    }

}
