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

        private boolean hasNoMoreChildren() {
            return children.isEmpty();
        }

        private void addChild(char ch) {
            children.put(ch, new TrieNode(ch));
        }

        private TrieNode getChild(char ch) {
            return children.get(ch);
        }

        private void removeChild(char ch) {
            children.remove(ch);
        }

        private TrieNode[] getChildren() {
            return children.values().toArray(new TrieNode[0]);
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

    public boolean contains(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.hasChild(c)) {
                return false;
            }
            node = node.getChild(c);
        }
        return node.isEnd;
    }

    public boolean containsRecursive(String word) {
        return containsRecursive(word, root);
    }

    private boolean containsRecursive(String word, TrieNode node) {
        if (word.isEmpty()) {
            return node.isEnd;
        }
        if (node.hasChild(word.charAt(0))) {
            return containsRecursive(word.substring(1), node.getChild(word.charAt(0)));
        }
        return false;
    }

    public void traversePreOrder() {
        System.out.println("Traverse Pre Order");
        traversePreOrder(root, "");
    }

    private void traversePreOrder(TrieNode node, String prefix) {
        if (node.isEnd) {
            String word = prefix + node.value;
            System.out.println(word.replace(" ", ""));
        }
        if (node.hasNoMoreChildren()) {
            return;
        }
        for (TrieNode child : node.children.values()) {
            traversePreOrder(child, prefix + node.value);
        }
    }

    public void autoCompleteWord(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return;
        }
        autoCompleteWord(prefix, root, "");
    }
    private void autoCompleteWord(String prefix, TrieNode node, String result) {
        if (node.isEnd) {
            String word = result + node.value;
            if (result.contains(prefix))
                System.out.println(word.replace(" ", ""));
        }
        if (node.hasNoMoreChildren()) {
            return;
        }
        for (TrieNode child : node.children.values()) {
            autoCompleteWord(prefix ,child, result + node.value);
        }
    }

    public void traversePostOrder() {
        System.out.println("Traverse Post Order");
        traversePostOrder(root, "");
    }

    private void traversePostOrder(TrieNode node, String prefix) {
        if (node.isEnd) {
            System.out.println(node.value + prefix);
        }
        if (node.hasNoMoreChildren()) {
            return;
        }
        for (TrieNode child : node.getChildren()) {
            traversePostOrder(child, node.value + prefix);
        }
    }

    public void remove(String word) {
        remove(word, root);
    }
    private void remove(String word, TrieNode node) {
        if (word.isEmpty()) {
            return;
        }
        TrieNode currentChild = node.getChild(word.charAt(0));
        if (currentChild != null && word.length() == 1) {
            currentChild.isEnd = false;
        }

        for (TrieNode child : node.getChildren()) {
            if (child.value == word.charAt(0)) {
                remove(word.substring(1), child);
            }
        }

        if (currentChild != null) {
            if (currentChild.hasNoMoreChildren() && !currentChild.isEnd) {
                node.removeChild(currentChild.value);
            }
        }

    }
}
