package javaPrograms.collectionFramework;

import java.util.ArrayList;
import java.util.Arrays;

public class ALDemo2 {
    public static void main(String[] args) {
        String empNames[]={"Sagar","Anjaneyulu","Sarika","Haritha","Sunitha","Ram"};
        Integer salaries[]={50000,10000,40000};
        String cities[]={"Hyderabad","Chennai","Pune","Bangalore"};

        ArrayList ob = new ArrayList(Arrays.asList(empNames));
        System.out.println(ob);

        ArrayList ob1 = new ArrayList(Arrays.asList(salaries));
        System.out.println(ob1);

        ArrayList ob2 = new ArrayList(Arrays.asList(cities));
        System.out.println(ob2);

        boolean b = ob.addAll(ob1);
        System.out.println(ob);
        System.out.println(b);

        ob.addAll(3,ob2);
        System.out.println(ob);


        /*ob.clear();
        System.out.println(ob);
        b=ob.isEmpty();
        System.out.println(b);*/

        Object ob9=ob.get(4);
        System.out.println(ob9);

        /*for(int i=0;i<ob.size();i++){
            Object o=ob.get(i);
            System.out.println(o);
        }*/

        for(Object o:ob){
            System.out.println(o);
        }
    }
}
