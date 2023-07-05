package javaPrograms.assignments.Assignmnt_17;

public class C extends B{
    //Parameterize constructor
    C(int a[]){
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum=sum+a[i];
        }
        System.out.println("Sum of the Array numbers is :"+sum);
    }

    int g=47;//instance variable
    static byte h=23;//class variable

    //instance method
    //method with arguments and without return type
    void checkNumber(int n){
        if(n>0){
            System.out.println("Given number is  Positive");
        }else if(n<0){
            System.out.println("Given number is Negative");
        }else{
            System.out.println("Given number is Zero");
        }
    }

    //class method
    //method with arguments and without return type
    static void compareNumbers(int a, int b){
        if(a>b){
            System.out.println("Max Number is a :"+a);
        }else{
            System.out.println("Max Number is b :"+b);
        }
    }
}
