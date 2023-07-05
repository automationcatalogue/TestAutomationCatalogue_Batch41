package javaPrograms.JavaFundamentals.Operators;

public class TernaryOperator {
    public static void main(String[] args) {
        int x=100, y=900;
        float z=(x>y)?10.56f:65.23f;
        System.out.println(z);
    }
}

class TernaryDemo2{

    public static void main(String args[]){
        char ch='G';
        char x1=(ch==99)?100:'G';
        int x2=(ch==99)?100:'G';
        System.out.println("x1 value is :"+x1+" x2 value is :"+x2);

        int x=89, y=100,z;
        z=(x>y)?x:y;
        System.out.println("z value is :"+z);

        z=(x<y)?300:500;
        System.out.println("z value is :"+z);
    }

}
