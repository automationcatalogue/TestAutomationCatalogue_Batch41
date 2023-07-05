package javaPrograms.JavaFundamentals.Statements;

public class BreakDemo {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            if(i==5){
                break;
            }
            System.out.println(i);

        }
    }
}

class BreakDemo1{
    public static void main(String[] args) {
        for(int n=5;n<=20;n=n+4){
            if(n>=16){
                break;
            }
            System.out.println(n);
            n++;
        }
    }
}
class BreakDemo2{
    public static void main(String[] args) {
        for(int i=1;i<=3;i++){
            for(int j=1;j<=10;j++){
                if(j==4){
                    break;
                }
                System.out.println(j);
            }
        }
    }
}
