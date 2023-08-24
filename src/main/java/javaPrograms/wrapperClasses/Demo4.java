package javaPrograms.wrapperClasses;

public class Demo4 {
    public static void main(String[] args) {
        String str = "Automation @Batch42 & Learning Core Java!!!";
        int l=str.length();

        int uc=0, lc=0,nc=0,sc=0;

        for(int i=0;i<l;++i){
            char ch=str.charAt(i);
            if(Character.isUpperCase(ch)){
                ++uc;
            }else if(Character.isLowerCase(ch)){
                ++lc;
            }else if(Character.isDigit(ch)){
                ++nc;
            }else {
                ++sc;
            }
        }

        System.out.println("Total number of uppercase alphabets are :"+uc);
        System.out.println("Total number of lowercase alphabets are :"+lc);
        System.out.println("Total number of numbers are :"+nc);
        System.out.println("Total number of special characters are :"+sc);
    }
}
