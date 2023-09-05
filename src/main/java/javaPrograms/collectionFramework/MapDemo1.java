package javaPrograms.collectionFramework;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapDemo1 {
    public static HashMap getMapData() {
        HashMap map = new HashMap();
        map.put("City","Hyderabad");
        Object ob = map.put("Color1","Green");
        //System.out.println(ob);
        map.put("Color2","Red");
        map.put("Gender",25);
        map.put(101,"Sagar");
        map.put("empSalary",52369.12);
        map.put(true,new Employee());

        //System.out.println(map);

        Object ob1 =map.put("City","Toronto");
        //System.out.println(map);
        //System.out.println(ob1);

        Object ob3 =map.put("Fruit","Orange");
       // System.out.println(ob3);
        //System.out.println(map);

        ob3=map.put("Fruit","banana");
        //System.out.println(ob3);
        //System.out.println(map);

        map.put("Capital","Toronto");
        //System.out.println(map);

        int x=map.size();
        //System.out.println("Size of the Map is :"+x);

        boolean b=map.isEmpty();
        //System.out.println(b);

        Object ob4=map.get(25);
        //System.out.println(ob4);

        b=map.containsValue("Toronto");
        //System.out.println(b);

        b=map.containsKey(102);
        //System.out.println(b);

        return map;
    }
}
