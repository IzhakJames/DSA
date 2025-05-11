import Graph.MyGraph;
import Tree.MyAVLTree;
import Tree.MyMaxHeap;
import Tree.MyTree;
import Tree.MyTrie;
import Tree.util.MaxHeap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.print();
        graph.removeNode("A");
        graph.print();
        graph.addEdge("C" , "B");
        graph.print();
    }
}