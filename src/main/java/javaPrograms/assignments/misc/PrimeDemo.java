package javaPrograms.assignments.misc;

public class PrimeDemo {
    public static void main(String[] args) {
        int n = 11;
        int i=1;
        int count =0;
        while(i<=n){
            if(n%i==0){
                ++count;
            }
            ++i;
        }
        if(count==2){
            System.out.println("Given number is Prime :"+n);
        }else{
            System.out.println("Given number is not Prime :"+n);
        }
    }
}
