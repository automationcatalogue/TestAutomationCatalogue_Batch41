package javaPrograms.collectionFramework;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        HashMap map1 =  MapDemo1.getMapData();
        LinkedHashMap map2= MapDemo2.getMapData();

        LinkedHashMap map3 = new LinkedHashMap(map1);
        map2.putAll(map3);
        System.out.println(map2);

        Set<Object> set = map2.keySet();
        for(Object ob:set){
            System.out.println(ob);
        }

        System.out.println("****************** VALUES *******************");
        Collection<Object> c= map2.values();
        for (Object ob:c){
            System.out.println(ob);
        }

        Object ob5=map2.getOrDefault("Krishna","785000");
        System.out.println(ob5);

        map2.putIfAbsent("Krishna",45230);
        System.out.println(map2);

    }
}
