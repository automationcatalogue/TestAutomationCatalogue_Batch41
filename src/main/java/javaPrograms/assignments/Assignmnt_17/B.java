package javaPrograms.assignments.Assignmnt_17;

public class B  extends A{
    int m=56;//instance variable
    static char ch='K';//class variable

    //instance method
    //method with arguments and without return type
    void primeDemo(int n){
        int sum=0, count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
        }
        if(count==2){
            System.out.println("Given number is Prime Number :"+count);
        }else{
            System.out.println("Given number is not Prime Number :"+count);
        }
    }

    //class method
    //method without arguments and without return type
    static void sumOfEvenNumbers(){
        int evenSum=0;
        for(int i=0;i<=20;i++){
            if(i%2==0){
                evenSum+=i;
            }
        }
        System.out.println("Sum of the Even numbers is :"+evenSum);
    }
}
