package Tree;

import java.util.HashMap;

public class MyTrie {

    private class TrieNode {
        char value;
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        private TrieNode(char value) {
            this.value = value;
            children = new HashMap<Character, TrieNode>();
        }

        private boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        private void addChild(char ch) {
            children.put(ch, new TrieNode(ch));
        }

        private TrieNode getChild(char ch) {
            return children.get(ch);
        }

    }

    private TrieNode root;

    public MyTrie() {
        this.root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.hasChild(c)) {
                node.addChild(c);
            }
            node = node.getChild(c);
        }
        node.isEnd = true;
    }
}
