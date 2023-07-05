package javaPrograms.assignments.Assignment_13;

public class Test {
    //instance method
    //method with return type and with arguments
    //method
    int checkPrime(int x[]){

        int primeSum=0;

        for(int y:x){

            int count=0;

            for(int i=1;i<=y;i++){

                if(y%i==0){
                    count++;
                }
            }
            if(count==2){
                System.out.println(y + " is a Prime Number ");
                primeSum=primeSum+y;
            }


        }

        return primeSum;

    }
}
