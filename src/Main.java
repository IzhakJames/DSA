
import Linear.MyHashMap;
import Linear.util.CharacterFinder;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap(10);
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(11, "11");
        map.put(11, "new 11");

        System.out.println(map.get(10));
        System.out.println(map.get(11));
        String removed = map.remove(1);
        System.out.println(removed);
    }
}