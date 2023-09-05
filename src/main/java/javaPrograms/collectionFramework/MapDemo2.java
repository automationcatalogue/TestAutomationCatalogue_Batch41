package javaPrograms.collectionFramework;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapDemo2 {
    public static LinkedHashMap getMapData() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

        String empNames[]={"Sagar","Sarika","Haritha","Anjaneyulu","Sunitha","Lavanya","Ramakrisna"};
        Integer empSalaries[]={10000,20000,50000,35000,25000,650000,99000};

        for(int i=0;i<empNames.length;i++){
            map.put(empNames[i],empSalaries[i]);
        }
        //System.out.println(map);
        map.put("Automation","Testing");
        //System.out.println(map);

        Object ob = map.remove("Sunitha");
       // System.out.println(ob);
        //System.out.println(map);

        map.replace("Lavanya",650000,"75000");
        //System.out.println(map);

        return map;

    }
}
