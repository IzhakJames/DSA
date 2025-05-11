package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MYWeightedGraph {

    private class Node {
        private String label;
        private List<Edge> edges;

        public Node(String label) {
            this.label = label;
            edges = new ArrayList<Edge>();
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from.label + " - " + to.label + " : " + weight;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException("Node " + from + " does not exist");
        }
        Node toNode = nodes.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException("Node " + to + " does not exist");
        }
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (Node source : nodes.values()) {
            List<Edge> adjacent = source.getEdges();
            System.out.println(source+ " is connected to " + adjacent);
        }
    }
}
