package javaPrograms.oops.Abstraction1;

public class Z implements X,Y{

    public void show(){
        int i=11, n=11;
        int count =0;
        while(i<=n){
            if(n%i==0){
                count =count+1;
            }
            ++i;
        }
        if(count==2){
            System.out.println("Given number is Prime :"+n);
        }else{
            System.out.println("Given number is not Prime :"+n);
        }
    }

    public static void main(String[] args) {
        Z ob = new Z();
        ob.show();
    }
}
