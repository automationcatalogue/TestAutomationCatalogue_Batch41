package javaPrograms.collectionFramework;

import java.util.HashSet;

public class HSDemo {
    public static void main(String[] args) {
        HashSet<Object> hs = new HashSet<Object>();
        hs.add("Automation");
        hs.add("Testing");
        hs.add(999);
        hs.add(56.23);
        hs.add('U');
        hs.add(new Employee());

        System.out.println(hs);
        hs.add(999);
        System.out.println(hs);


    }
}
