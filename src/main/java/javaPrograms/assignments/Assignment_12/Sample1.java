package javaPrograms.assignments.Assignment_12;

public class Sample1 {

    void checkArmStrong(int y){
        int temp=y;
        int sum=0;

        while(y!=0){
            int r = y%10;
            sum =sum+(r*r*r);
            y=y/10;
        }

        if(temp==sum){
            System.out.println("Given number is a ArmStrong number :"+temp);
        }else{
            System.out.println("Given number is Not a ArmStrong number :"+temp);
        }
    }
}
