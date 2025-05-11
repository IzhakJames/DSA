import Graph.MYWeightedGraph;
import Graph.MyGraph;

public class Main {
    public static void main(String[] args) {
        MYWeightedGraph graph = new MYWeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B",5);
        graph.addEdge("B", "C",2);
        graph.addEdge("C", "D",5);
//        graph.addEdge("D", "A");

        graph.print();
    }
}