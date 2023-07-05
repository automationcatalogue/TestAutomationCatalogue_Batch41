package javaPrograms.stringHandling;

public class Assignment3 {

    public static void main(String[] args) {
        String str= "Test Automation Java Learning";

        String str1[]=str.split(" ");
        String temp="";

        for(int i=str1.length-1;i>=0;i--){
            temp=temp+" "+str1[i];
        }
        System.out.println(temp.trim());
    }

}
