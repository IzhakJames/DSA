package Tree;


import java.util.Arrays;

public class MyTrie {
    public static int ALPHABET_SIZE = 26;

    private class TrieNode {
        String value;
        TrieNode[] children;
        boolean isEnd;

        TrieNode(String value) {
            this.value = value;
            children = new TrieNode[ALPHABET_SIZE];
            isEnd = false;
        }

        @Override
        public String toString() {
            return String.format("Value: %s with children %s", value, Arrays.toString(children));
        }
    }

    private TrieNode root;

    public MyTrie() {
        this.root = new TrieNode(null);
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            TrieNode newLetter = new TrieNode(String.valueOf(c));
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = newLetter;
            }
            node = node.children[c - 'a'];

        }
        node.isEnd = true;
    }

    private boolean containsLetter(TrieNode[] children, String letter) {
        for (TrieNode node : children) {
            if (node.value.equals(letter)) return true;
        }
        return false;
    }
}
