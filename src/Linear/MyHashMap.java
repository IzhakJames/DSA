package Linear;

import java.util.LinkedList;

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
            items[hash] = new LinkedList<KeyValuePair>();
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
