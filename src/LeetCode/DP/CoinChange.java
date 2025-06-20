package LeetCode.DP;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CoinChange {
    public int solutionQ322(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int min = amount+1;
        for (int num : coins) {
            min = Math.min(num, min);
            map.put(num, 1);
        }
        int current = min;
        for (int i = current; i<amount+1; i++) {
            for (int num : coins) {
                if (num > i) {
                    continue;
                }
                int count = map.getOrDefault(num,0);
                int remaining = i - num;
                if (map.containsKey(remaining)) {
                    count += map.get(remaining);
                    remaining -= remaining;
                }
                if (count > 0 && remaining == 0) {
                    if (map.containsKey(i)) {
                        int currCount = map.get(i);
                        map.put(i, Math.min(currCount, count));
                    } else {
                        map.put(i, count);
                    }
                }
            }
        }

        return map.getOrDefault(amount,-1);
    }
}
