package javaPrograms.collectionFramework;

import java.util.ArrayList;

public class ALDemo1 {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("Automation");
        al.add("Selenium");
        al.add(999);
        al.add(123.45);
        System.out.println(al);

        System.out.println("******* Array Values********");
        Object ob[]=al.toArray();
        for(int i=0;i<ob.length;i++){
            System.out.println(ob[i]);
        }
    }
}
