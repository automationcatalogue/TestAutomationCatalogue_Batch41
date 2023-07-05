package javaPrograms.oops.polymorphism.MethodOerriding;

public class Test1 {

    public void show(int x){
        int count=0;
        for(int i=1;i<=x;i++){
            if(x%i==0){
                count++;
            }
        }
        if(count==2){
            System.out.println("Given number "+x+" is prime number");
        }else{
            System.out.println("Given number "+x+" is not prime number");
        }
    }

    public void display(int x){
        if(x%2==0){
            System.out.println("Given number "+x+" is a Even number");
        }else{
            System.out.println("Given number "+x+" is a Odd number");
        }
    }

}
