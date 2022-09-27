import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap; 

public class HashMap_01{


    public static void main(String[] args) {
        
        // creating map

        // hashmap stores key in random order
        Map<String,Integer> map_1 = new HashMap<>();
        // linkedhashmap store key in order in which they inserted
        Map<String,Integer> map_2 = new LinkedHashMap<>();
        // treemap store the key in sorted orrder
        Map<String,Integer> map_3 = new TreeMap<>();

        // insertion
        map_1.put("mera", 1);
        map_1.put("naam", 2);
        map_1.put("hai", 3);
        map_1.put("lande", 4);
        map_1.put("harshad", 5);
        
        map_2.put("mera", 1);
        map_2.put("naam", 2);
        map_2.put("hai", 3);
        map_2.put("harshad", 5);
        map_2.put("lande", 4);
        map_2.put("harshad", 7);   // here harshad is already in map so value get update
    
        map_3.put("mera", 1);
        map_3.put("naam", 2);
        map_3.put("hai", 3);
        map_3.put("lande", 4);
        map_3.put("harshad", 5);
    

        // traversing in map
        for (Map.Entry<String,Integer> entry : map_1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
        for (Map.Entry<String,Integer> entry : map_2.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
        for (Map.Entry<String,Integer> entry : map_3.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();


        // searching
        System.out.println(map_1.get("harshad"));
        System.out.println(map_1.get("harry")); // null
        System.out.println();

        // in c++
        // case 1 
        // cout<<map_1.at["unknown"];     // error
        // case 2 
        // cout<<map_1["unknown"];        // 0
        // case 3
        // cout<<map_1["unknown"];        // 0              it creates an entry for "unknown"
        // cout<<map_1.at["unknown"];     // 0


        // size
        System.out.println(map_2.size());
        System.out.println();

        // find key exist or not
        System.out.println(map_1.containsKey("bro"));
        System.out.println(map_1.containsKey("mera"));
        System.out.println();

        // delete
        map_1.remove("h");
        System.out.println(map_1.size());
        map_1.remove("hai");
        System.out.println(map_1.size());

        
            
    }

}