package javaPrograms.wrapperClasses;

public class Demo5 {
    public static void main(String[] args) {
        String orderNumber="Amazon Order Number:TZ367AC";
        String s[]=orderNumber.split(":");
        System.out.println(s[0]);
        System.out.println(s[1]);

        int x=Integer.parseInt(s[1]);
        if(x%2==0){
            System.out.println("OrderNumber is Even!!!");
        }else{
            System.out.println("OrderNumber is Odd!!!");
        }
    }
}
