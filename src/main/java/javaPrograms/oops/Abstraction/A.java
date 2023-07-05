package javaPrograms.oops.Abstraction;

abstract public class A {

    //abstract method - instance method
    abstract void show();

    //Non-abstract method - instance method
    void print(int x){
        int count=0;
        for(int i=1;i<=x;i++){
            if(x%i==0){
                count++;
            }
        }
        if(count==3){
            System.out.println(x+" is a Prime Number");
        }else{
            System.out.println(x+" is not a Prime Number");
        }
    }
}
