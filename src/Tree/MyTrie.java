package Tree;


import java.util.Arrays;
import java.util.HashMap;

public class MyTrie {
//    public static int ALPHABET_SIZE = 26;

    private class TrieNode {
        char value;
        HashMap<Character, TrieNode> children;
        boolean isEnd;

//        TrieNode(char value) {
//            this.value = value;
//            children = new TrieNode[ALPHABET_SIZE];
//            isEnd = false;
//        }
        public TrieNode(char value) {
            this.value = value;
            children = new HashMap<Character, TrieNode>();
        }
    }

    private TrieNode root;

    public MyTrie() {
        this.root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode(c));
            }
            node = node.children.get(c);
        }
        node.isEnd = true;
    }
}
