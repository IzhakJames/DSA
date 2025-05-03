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
            LinkedList<KeyValuePair> list = new LinkedList<KeyValuePair>();
            list.add(new KeyValuePair(key, value));
            items[hash] = list;
        } else {
            for  (KeyValuePair pair : items[hash]) {
                if (pair.key == key) {
                    pair.value = value;
                    return;
                }
            }
            items[hash].add(new KeyValuePair(key, value));
        }
        size++;
    }

    public String get(int key) {
        int hash = hash(key);
        if (items[hash] == null) {
            return null;
        }
        LinkedList<KeyValuePair> list = items[hash];
        for (KeyValuePair pair : list) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return null;
    }

    public String remove(int key) {
        int hash = hash(key);
        if (items[hash] == null) {
            return null;
        }
        size--;
        LinkedList<KeyValuePair> list = items[hash];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                return list.remove(i).value;
            }
        }
        return null;
    }

}
