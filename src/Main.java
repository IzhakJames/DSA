import Graph.MyWeightedGraph;

public class Main {
    public static void main(String[] args) {
        MyWeightedGraph graph = new MyWeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B",3);
        graph.addEdge("B", "D",4);
        graph.addEdge("C", "D",5);
        graph.addEdge("A", "C",1);
        graph.addEdge("B", "C",2);
        graph.print();
        graph.removeNode("B");
        System.out.println();
        graph.print();
//        System.out.println(graph.getShortestDistance("A", "D"));
//        System.out.println(graph.hasCycle());
//        MyWeightedGraph minSpanTree = graph.getMinimumSpanningTree();
//        System.out.println();
//        minSpanTree.print();
//        System.out.println(minSpanTree.getShortestDistance("A", "D"));
//        System.out.println(minSpanTree.hasCycle());
    }
}