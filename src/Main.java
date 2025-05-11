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
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        graph.addEdge("X", "A");
        graph.addEdge("X", "B");
        graph.addEdge("A", "P");
        graph.addEdge("B", "P");
        graph.addEdge("P", "X");

        graph.print();
        System.out.println(graph.hasCycle());
    }
}