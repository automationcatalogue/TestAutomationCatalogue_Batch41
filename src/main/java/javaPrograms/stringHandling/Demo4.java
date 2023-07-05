package javaPrograms.stringHandling;

public class Demo4 {
    public static void main(String[] args) {
        String s1="Automation";
        char ch[]=s1.toCharArray();

        for(int i=0;i<ch.length;i++){
            System.out.println(ch[i]);
        }

        char ch1=s1.charAt(4);
        System.out.println(ch1);
    }
}
