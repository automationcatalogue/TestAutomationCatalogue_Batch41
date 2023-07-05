package javaPrograms.JavaFundamentals.Statements;

public class BreakContinueDemo {
    //Object creation
    BreakContinueDemo ob1 = new BreakContinueDemo();

    public static void main(String[] args) {

        for(int i=1;i<=10;i++){
            if(i<5) {
                System.out.println("Advanced Java");
            }

            if(i>6) {
                break;
            }

            System.out.println(i);
        }
    }
}
