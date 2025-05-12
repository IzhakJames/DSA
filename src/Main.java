import Graph.MyWeightedGraph;

public class Main {
    public static void main(String[] args) {
        MyWeightedGraph graph = new MyWeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
//        graph.addEdge("A", "B",5);
        graph.addEdge("B", "C",2);
        graph.addEdge("B", "D",3);
        graph.addEdge("C", "D",1);
//        graph.addEdge("D", "E",1);
        graph.addEdge("E", "A",1);

//        graph.addEdge("D", "A");

        graph.print();
//        System.out.println(graph.getShortestDistance("A","C"));
        System.out.println(graph.hasCycle());
    }
}