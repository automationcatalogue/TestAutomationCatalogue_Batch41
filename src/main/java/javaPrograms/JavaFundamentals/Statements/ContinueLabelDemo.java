package javaPrograms.JavaFundamentals.Statements;

public class ContinueLabelDemo {
    public static void main(String[] args) {
        Aparna: for(int i=1;i<=3;i++){

            Kavya: for(int j=1;j<=10;j++){
                if(j==5){
                    continue Aparna;
                }
                System.out.println(j);
            }

        }
    }
}
