package javaPrograms.assignments.Assignment_12;

public class Sample4 {

    static int checkPrime(int x){
        int count=0;
        for(int i=1;i<=x;i++){
            if(x%i==0){
                count++;
            }
        }

        if(count==2){
            System.out.println("Given number is Prime :"+x);
        }else{
            System.out.println("Given number is not Prime :"+x);
        }

        x++;

        return x;
    }

}
