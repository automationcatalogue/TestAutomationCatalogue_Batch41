package javaPrograms.collectionFramework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class LHSDemo {
    public static void main(String[] args) {
        ArrayList<Object> al = new ArrayList<>();
        al.add("Anjaneyulu");
        al.add('K');
        al.add(500);
        al.add("Testing");
        al.add(500);
        al.add("Anjaneyulu");
        al.add(false);
        System.out.println(al);

        HashSet hs = new HashSet(al);
        System.out.println(hs);

        LinkedHashSet lhs = new LinkedHashSet(al);
        System.out.println(lhs);
    }
}
