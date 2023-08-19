package javaPrograms.wrapperClasses;

public class Demo3 {
    public static void main(String[] args) {
        char ch1='j';
        boolean b1=Character.isUpperCase(ch1);
        boolean b2=Character.isLowerCase(ch1);

        if(b1){
            System.out.println("Given Character is uppercase");
        }else if(b2){
            System.out.println("Given Character is lowercase");
        }else if(Character.isDigit(ch1)){
            System.out.println("Given Character is Number");
        }else{
            System.out.println("Given Character is Special character");
        }

    }
}
