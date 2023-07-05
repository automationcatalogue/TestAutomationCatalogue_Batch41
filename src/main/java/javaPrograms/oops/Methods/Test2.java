package javaPrograms.oops.Methods;

public class Test2 {
    //class method
    //method with No arguments and with No return type
    //method definition

    static void primeDemo(){
        int x=11;
        int count=0;
        for(int i=1;i<=x;i++){
            if(x%i==0){
                count++;
            }
        }
        if(count==2){
            System.out.println("Given number x is Prime number :"+x);
        }else{
            System.out.println("Given number x is not Prime number :"+x);
        }
    }
}
