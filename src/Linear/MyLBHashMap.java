package Linear;

// This HashMap implementation uses Linear Probing for Collisions
public class MyLBHashMap {
    private class KeyValuePair {
        int key;
        String value;

        public KeyValuePair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    KeyValuePair[] items;
    int size = 0;

    public MyLBHashMap(int size) {
        this.items = new KeyValuePair[size];
    }

    private int hash(int key, int i) {
        return (key + i) % items.length;
    }

    private boolean isFull() {
        return size == items.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void put(int key, String value) {
        if (isFull()) {
            throw new RuntimeException("Map is full");
        }
        int iteration = 0;
        int hash = hash(key, iteration);
        KeyValuePair bucket = items[hash];
        if (bucket != null) {
            if (bucket.key == key) {
                bucket.value = value;
                return;
            } else {
                while (items[hash] != null) {
                    hash = hash(key, ++iteration);
                }
            }
        }
        size++;
        items[hash] = new KeyValuePair(key, value);
    }

    public String get(int key) {
        if (isEmpty()) {
            throw new IllegalStateException("Map is empty");
        }
        int iteration = 0;
        int hash = hash(key, iteration);
        int start = hash;
        KeyValuePair bucket = items[hash];
        if (bucket == null) {
            return null;
        } else {
            if (bucket.key == key) {
                return bucket.value;
            } else {
                while (items[hash].key != key) {
                    hash = hash(key, ++iteration);
                    if (items[hash] == null || start == hash) {
                        return null;
                    }
                }
                return items[hash].value;
            }
        }
    }

    public String remove(int key) {
        if (isEmpty()) {
            throw new IllegalStateException("Map is empty");
        }
        int iteration = 0;
        int hash = hash(key, iteration);
        int start = hash;
        KeyValuePair bucket = items[hash];
        if (bucket == null) {
            throw new IllegalStateException("Key not found");
        } else {
            if (bucket.key == key) {
                items[hash] = null;
                size--;
                return bucket.value;
            } else {
                while (items[hash].key != key) {
                    hash = hash(key, ++iteration);
                    if (items[hash] == null || start == hash) {
                        throw new IllegalStateException("Key not found");
                    }
                }
                KeyValuePair item = items[hash];
                items[hash] = null;
                size--;
                return item.value;
            }
        }
    }

}
