package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Directed Graph
public class MyGraph {
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

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String firstLabel, String secondLabel) {
        Node firstNode = nodes.get(firstLabel);
        if (firstNode == null) {
            throw new IllegalArgumentException("First node not found");
        }

        Node secondNode = nodes.get(secondLabel);
        if (secondNode == null) {
            throw new IllegalArgumentException("Second node not found");
        }

        adjacencyList.get(firstNode).add(secondNode);
    }

    public void removeNode(String word) {
        Node node = nodes.get(word);
        if (node == null) {
            return;
        }
        //Remove edges
        for (Node sourceNode : adjacencyList.keySet()) {
            adjacencyList.get(sourceNode).remove(node);
        }
        adjacencyList.remove(node);
        nodes.remove(word);
    }

    public void removeEdge(String firstLabel, String secondLabel) {
        Node firstNode = nodes.get(firstLabel);
        Node secondNode = nodes.get(secondLabel);
        if (firstNode == null || secondNode == null) {
            return;
        }

        adjacencyList.get(firstNode).remove(secondNode);


    }

    public void print() {
        for (Node source : adjacencyList.keySet()) {
            List<Node> adjacent = adjacencyList.get(source);
            System.out.println(source+ " is connected to " + adjacent);
        }
    }
}
