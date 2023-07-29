package javaPrograms.latest.Demo;

public class Demo1 {

    //instance method
    //method without return type and with arguments
    void add(int x, int y, int z){
        int a=x+y+z;
        System.out.println("Addition of '3' numbers is :"+a);
    }

    //class method
    //method without return type and with arguments
    static void prime(int x){
        int count=0;
        for(int i=1;i<=x;++i){
            if(x%i==0){
                ++count;
            }
        }
        if(count==2){
            System.out.println("Prime Number!!!");
        }else{
            System.out.println("Not Prime!!!");
        }
    }
}
