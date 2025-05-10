import Tree.MyAVLTree;
import Tree.MyMaxHeap;
import Tree.MyTree;
import Tree.MyTrie;
import Tree.util.MaxHeap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyTrie myTrie = new MyTrie();
        myTrie.insert("cat");
        myTrie.insert("catch");
        myTrie.insert("cotton");
        myTrie.insert("dog");
        myTrie.insert("snake");
        System.out.println(myTrie.containsRecursive("ca"));
    }
}