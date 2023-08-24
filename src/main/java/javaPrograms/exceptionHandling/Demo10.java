package javaPrograms.exceptionHandling;

public class Demo10 {
    public static void main(String[] args) {
        BankAccount ob1 = new BankAccount();
        try{
            ob1.withdrawMoney(50000);
        }catch(Exception ob2){
            System.out.println("Account Balance is not sufficient, please maintain the sufficient balance");
        }

    }
}
