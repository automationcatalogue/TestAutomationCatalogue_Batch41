package javaPrograms.collectionFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCountDemo {
    public static void main(String[] args) {
        String str ="Core Java Program is Easy and Java Program is divided into Core Java and Advanced Java and Java Program Learning";
        String s[]= str.split(" ");

        HashMap<String, Integer> map = new HashMap<String, Integer>();


        for(String s1:s){
            Integer count = map.get(s1);
            if(map.containsKey(s1)){
                map.put(s1,count+1);
            }else{
                map.put(s1,1);
            }
        }
        System.out.println(map);

        Set<Map.Entry<String, Integer>> entries =  map.entrySet();
        for(Map.Entry<String, Integer> entry:entries){
            Integer count  = entry.getValue();
            if(count>1){
                String key = entry.getKey();
                System.out.println(key+"--"+count);
            }
        }
    }

}
