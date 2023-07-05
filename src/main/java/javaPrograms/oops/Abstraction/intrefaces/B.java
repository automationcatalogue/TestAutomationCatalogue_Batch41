package javaPrograms.oops.Abstraction.intrefaces;

public class B implements A{
    int y=10;

    public void show(){
        int x=11, count=0;
        for(int i=1;i<=x;i++){
            if(x%i==0){
                count++;
            }
        }
        if(count==2){
            System.out.println(x+" is a Prime Number");
        }else{
            System.out.println(x+" is not a Prime Number");
        }
    }

    public void print(){
        int x=5;
        if (x%2==0){
            System.out.println(x+" is a Even number");
        }else{
            System.out.println(x+" is a Odd Number");
        }
    }

    public void display(){
        int x=5;
        int y=x*x*x;
        System.out.println("Cube of the given number is :"+y);
    }
}
