package javaPrograms.assignments.Assignmnt_17;

public class A {
    int x=10;//instance variable
    static float y=20.05f;//class variable

    //instance method
    //method with arguments and with return type
    int addNumbers(int a, int b){
        int c=a+b;
        return c;
    }


    //class method
    //method without arguments and with return type
    static boolean evenOdd(){
        int x=10;
        boolean flag;
        if(x%2==0){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }
}
