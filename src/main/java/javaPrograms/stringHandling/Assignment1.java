package javaPrograms.stringHandling;

public class Assignment1 {
    public static void main(String[] args) {
        String s1="Test Automation Java";
        //op: noitamotuA tseT

        char ch[]=s1.toCharArray();
        int l = s1.length();

        char temp[] = new char[l];
        int j=0;

        for(int i=l-1;i>=0;i--){
            temp[j]=ch[i];
            j++;
        }

        String s2= new String(temp);
        System.out.println(s2);

    }
}
