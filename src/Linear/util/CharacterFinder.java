package Linear.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharacterFinder {
    public static Character findFirstNonRepeatingCharacter(String input) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] charArray = input.replace(" ", "").toCharArray();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : charArray) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return Character.MIN_VALUE;
    }

    public static Character findFirstRepeatingCharacter(String input) {
        Set<Character> set = new HashSet<Character>();
        char[] charArray = input.replace(" ", "").toCharArray();
        for (char c : charArray) {
            if (set.contains(c)) {
                return c;
            } else  {
                set.add(c);
            }
        }
        return Character.MIN_VALUE;
    }
}
