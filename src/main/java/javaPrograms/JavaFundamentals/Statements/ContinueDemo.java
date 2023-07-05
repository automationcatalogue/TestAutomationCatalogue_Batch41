package javaPrograms.JavaFundamentals.Statements;

public class ContinueDemo {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            if(i==5){
                continue;
            }
            System.out.println(i);
        }
    }

}

class ContinueDemo1{
    public static void main(String[] args) {
        for(int i=1;i<=3;i++){
            for(int j=1;j<=10;j++){
                if(j>5){
                    continue;
                }
                System.out.println(j);
            }
        }
    }
}
