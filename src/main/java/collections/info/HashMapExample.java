package collections.info;

import java.util.HashMap;

/**
 * Created by Osman on 3:09 PM
 */
public class HashMapExample {
    public static void main(String[] args) {

        HashMap<Integer,String> maps = new HashMap<>();
        maps.put(12,"fkf");
        System.out.println(maps.get(12));
        System.out.println(maps.get(13));
    }
}
