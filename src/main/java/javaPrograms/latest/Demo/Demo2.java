package javaPrograms.latest.Demo;

public class Demo2 {
    //instance method
    //method with return type and without arguments
    int fact(){
        int fact=1;
        for(int i=fact;i>=1;--i){
            fact=fact*i;
        }
        System.out.println("factorial of a number is "+fact);
        return fact;
    }

    //class method
    //method with return type and without arguments
    static float square(){
        float x=4.56f;
        float y=x*x;
        return y;
    }
}
