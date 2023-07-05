package javaPrograms.assignments.Assignment_16;

//B --> child class
//A --> parent class
public class B extends A{

    int sample=55;//instance variable

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
            System.out.println(n+" is a Prime Number");
        }else{
            System.out.println(n+" is not a Prime Number");
        }
    }

}
