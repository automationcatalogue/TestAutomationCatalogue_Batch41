package javaPrograms.exceptionHandling;

public class BankAccount {
    int accountBalance=10000;

    public void withdrawMoney(int amount) throws InsufficientBalanceException{
        if(amount<=accountBalance){
            accountBalance=accountBalance-amount;
        }else{
            throw new InsufficientBalanceException();
        }
    }
}
