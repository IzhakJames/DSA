package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MYWeightedGraph {

    private class Node {
        String label;

        Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        Node from;
        Node to;
        int weight;

        Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from.label + " -> " + to.label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
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
        Edge edge = new Edge(fromNode, toNode, weight);
        adjacencyList.get(fromNode).add(edge);
        adjacencyList.get(toNode).add(edge);
    }

    public void print() {
        for (Node source : adjacencyList.keySet()) {
            List<Edge> adjacent = adjacencyList.get(source);
            System.out.println(source+ " is connected to " + adjacent);
        }
    }
}
