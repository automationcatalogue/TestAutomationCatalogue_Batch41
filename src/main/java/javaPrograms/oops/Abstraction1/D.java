package javaPrograms.oops.Abstraction1;

public class D implements A{

    public void show(){
       int n=131;
        int sum=0;
        int temp=n;

        for(;n!=0;){
            int r=n%10;
            sum=sum+(r*r*r);
            n=n/10;
        }

        if(sum==temp){
            System.out.println("Given number is Armstrong number "+temp);
        }else{
            System.out.println("Given number is not Armstrong number "+temp);
        }
    }
}
