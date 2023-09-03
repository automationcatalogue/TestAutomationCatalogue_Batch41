package javaPrograms.collectionFramework;

import java.util.ArrayList;

public class ALDemo {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("Testing");
        al.add(500);
        al.add(58.39);
        al.add('U');
        al.add(false);
        al.add(500);
        al.add(null);

        Employee e1 = new Employee();
        Employee e2 = new Employee();

        al.add(e1);
        al.add(e2);

        System.out.println(al);

        int x=al.size();
        System.out.println("Size of the ArrayList is :"+x);

        boolean b1 = al.isEmpty();
        System.out.println("Before Clearing:"+b1);

        /*al.clear();
        System.out.println(al);

        boolean b = al.isEmpty();
        System.out.println("AfterClearing :"+b);*/

        boolean b2 = al.contains(500);
        System.out.println(b2);

        int p = al.indexOf('U');
        System.out.println("Position of U is :"+p);

        p=al.lastIndexOf(500);
        System.out.println("Last Index position of 500 is :"+p);
    }
}
