package javaPrograms.stringHandling;

public class Assignment2 {
    public static void main(String[] args) {
        String s1="Test A9utom1maJav @Hyder#mation";
        int UCount=0, LCount=0, NCount=0, SCount=0;

        char ch[] = s1.toCharArray();
        for(int i=0;i<ch.length;i++){

            if(ch[i]>=65 && ch[i]<=90){
                UCount++;
            }else if(ch[i]>=97 && ch[i]<=122){
                LCount++;
            }else if(ch[i]>=48 && ch[i]<=57){
                NCount++;
            }else{
                SCount++;
            }

        }

        System.out.println("Number of Uppercase characters "+UCount);
        System.out.println("Number of Lowercase characters "+LCount);
        System.out.println("Number of number characters "+NCount);
        System.out.println("Number of Speacial characters "+SCount);

    }
}

class Demo11{
    public static void main(String[] args) {
        String s1="Test A9utom1maJav @Hyder#mation";
        int UCount=0, LCount=0, NCount=0, SCount=0;

        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);

            if(ch>=65 && ch<=90){
                UCount++;
            }else if(ch>=97 && ch<=122){
                LCount++;
            }else if(ch>=48 && ch<=57){
                NCount++;
            }else{
                SCount++;
            }

        }

        System.out.println("Number of Uppercase characters "+UCount);
        System.out.println("Number of Lowercase characters "+LCount);
        System.out.println("Number of number characters "+NCount);
        System.out.println("Number of Speacial characters "+SCount);

    }
}
