package seleniumPrograms.sagarTeachings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        int x=10;
        System.out.println(x);

        String str1 ="QA";
        System.out.println(str1);

        System.out.println("**********Printing the Array values*****************");
        String str2[] = {"Audi","Benz","Honda","Jaguar"};

        for(int i=0;i<str2.length;i++){
            System.out.println(str2[i]);
        }

        System.out.println("****************Printing the List of Values**************************");
        List<String> str3 = new ArrayList<>(List.of("Hyderabad","Toronto","Bangalore","Chennai","Newyork"));
        for(int i=0;i<str3.size();i++){
            System.out.println(str3.get(i));
        }

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("fruits","apple");
        map.put("fruits","banana");
        map.put("fruits","oranges");
        System.out.println(map);


    }
}
