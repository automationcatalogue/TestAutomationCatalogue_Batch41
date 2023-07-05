package javaPrograms.oops.FinalAndAccessModifiers;

public class Demo {

    int x=10;//instance variable


    private void print(){
        int x=5;
        int y=x*x*x;
        System.out.println("Cube of the given number is :"+y);
    }

    private static void main(String[] args) {

        Demo ob1 = new Demo();
        System.out.println(ob1.x);

        if(ob1.x%2==0){
            System.out.println("Given Number is Even");
        }
    }
}
