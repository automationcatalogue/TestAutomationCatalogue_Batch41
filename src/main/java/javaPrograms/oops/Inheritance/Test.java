package javaPrograms.oops.Inheritance;

public class Test {
    int empNo=101;

    //instance method
    int sumEmpSalary(int salaries[]){
        int sum=0;
        for(int i=0;i<salaries.length;i++){
            sum=sum+salaries[i];
        }
        return sum;
    }
}
