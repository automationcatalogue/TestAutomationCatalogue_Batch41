package javaPrograms.oops.misc;

public class ArrayDemo {

    ArrayDemo(){

    }

    public static void main(String[] args) {
        int a[]={72,45,500,68,95,85,-76, -34};

        for(int i=0;i<8;i++){
            if(a[i]%2==0){
                System.out.println("Even Number :"+a[i]);
            }else{
                System.out.println("Odd Number :"+a[i]);
            }
        }


    }

}
