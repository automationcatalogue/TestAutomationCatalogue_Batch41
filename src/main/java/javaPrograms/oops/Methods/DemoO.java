package javaPrograms.oops.Methods;

public class DemoO {

    //class method
    //method with arguments and with return type
    //method definiton
    static int max(int a, int b){
        int temp;
        if(a>b){
            temp=a;
        }else{
            temp=b;
        }

        return temp;
    }

    int factorial(int x){
        int fact=1;
        for(int i=1;i<=x;i++){
            fact=fact*i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int data=max(4,7);

        DemoO ob1 = new DemoO();
        int z=ob1.factorial(data);
        System.out.println("Final value is :"+z);

    }



}
