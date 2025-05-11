import Graph.MYWeightedGraph;
import Graph.MyGraph;

public class Main {
    public static void main(String[] args) {
        MYWeightedGraph graph = new MYWeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B",5);
        graph.addEdge("B", "C",2);
//        graph.addEdge("D", "A");

        graph.print();
        System.out.println(graph.getShortestDistance("A","C"));
    }
}