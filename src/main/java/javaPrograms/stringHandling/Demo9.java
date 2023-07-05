package javaPrograms.stringHandling;

public class Demo9 {
    public static void main(String[] args) {
        String s1="Testing";
        char ch[]=s1.toCharArray();

        for(int i=0;i<ch.length;i++){
            System.out.println(ch[i]);
        }

        byte b[]=s1.getBytes();
        for(int i=0;i<s1.length();i++){
            System.out.println(b[i]);
        }
    }
}
