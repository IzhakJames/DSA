package Linear;

import java.util.LinkedList;

/*
 * HashMap Operations Complexity:
 *
 * put(K, V)        -> O(1) avg, O(n) worst     // Insert or update a key-value pair
 * get(K)           -> O(1) avg, O(n) worst     // Retrieve value by key
 * remove(K)        -> O(1) avg, O(n) worst     // Remove key-value pair by key
 * containsKey(K)   -> O(1) avg, O(n) worst     // Check if a key exists
 * containsValue(V) -> O(n)                     // Check if a value exists (linear search)
 * keySet()         -> O(n)                     // Returns Set of all keys
 * values()         -> O(n)                     // Returns Collection of all values
 * entrySet()       -> O(n)                     // Returns Set of Map.Entry<K,V> for iteration
 * size()           -> O(1)                     // Get number of key-value pairs
 * clear()          -> O(1)                     // Remove all entries
 * isEmpty()        -> O(1)                     // Check if map is empty
 */

// HashMaps in Java uses chaining for collisions
public class MyHashMap {
    private class KeyValuePair {
        int key;
        String value;
        public KeyValuePair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private final LinkedList<KeyValuePair>[] items;
    private int size;
    public MyHashMap(int size) {
        this.items =  new LinkedList[size];
    }

    private int hash(int key) {
        return key % items.length;
    }

    public void put(int key, String value) {
        int hash = hash(key);
        if (items[hash] == null) {
            items[hash] = new LinkedList<>();
        }

        LinkedList<KeyValuePair> bucket = items[hash];
        for  (KeyValuePair pair : bucket) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }

        bucket.add(new KeyValuePair(key, value));
        size++;
    }

    public String get(int key) {
        int hash = hash(key);
        if (items[hash] != null) {
            LinkedList<KeyValuePair> bucket = items[hash];
            for (KeyValuePair pair : bucket) {
                if (pair.key == key) {
                    return pair.value;
                }
            }
        }
        return null;
    }

    public String remove(int key) {
        int hash = hash(key);
        if (items[hash] != null) {
            LinkedList<KeyValuePair> bucket = items[hash];
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).key == key) {
                    size--;
                    return bucket.remove(i).value;
                }
            }
        }
        return null;
    }

}
