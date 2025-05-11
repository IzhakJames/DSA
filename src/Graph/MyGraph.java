package Graph;

import java.util.*;

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

    public void traverseDepthFirst(String word) {
        Node node = nodes.get(word);
        if (node == null) {
            throw new IllegalArgumentException("Node not found");
        }
        traverseDepthFirst(node, new HashSet<Node>());
    }

    // Pre- Order
    private void traverseDepthFirst(Node node, Set<Node> visited) {
        System.out.println(node.label);
        for (Node sourceNode : adjacencyList.get(node)){
            if (!visited.contains(sourceNode)) {
                visited.add(sourceNode);
                traverseDepthFirst(sourceNode, visited);
            }
        }
    }

    public void traverseDepthFirstIterative(String word) {
        Node node = nodes.get(word);
        if (node == null) {
            throw new IllegalArgumentException("Node not found");
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node.label);
            for (Node sourceNode : adjacencyList.get(node)) {
                if (!visited.contains(sourceNode)) {
                    visited.add(sourceNode);
                    stack.push(sourceNode);
                }
            }
        }
    }

    public void traverseBreathFirst(String word) {
        Node node = nodes.get(word);
        if (node == null) {
            throw new IllegalArgumentException("Node not found");
        }
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.label);
            for (Node sourceNode : adjacencyList.get(node)) {
                if (!visited.contains(sourceNode)) {
                    visited.add(sourceNode);
                    queue.offer(sourceNode);
                }
            }
        }
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for (Node node : adjacencyList.keySet()) {
            topologicalSort(node, visited, stack);
        }
        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop().label);
        }
        return list;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (Node sourceNode : adjacencyList.get(node)) {
            topologicalSort(sourceNode, visited, stack);
        }
        stack.push(node);
    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        boolean hasCycle = false;
        for (Node node : adjacencyList.keySet()) {
            hasCycle = hasCycle(node, visited, visiting);

        }
        return hasCycle;
    }

    private boolean hasCycle(Node node, Set<Node> visited, Set<Node> visiting) {
        visiting.add(node);
        for (Node sourceNode : adjacencyList.get(node)) {
            if (visited.contains(sourceNode)) {
                continue;
            }
            if (visiting.contains(sourceNode)) {
                return true;
            }
            boolean result = hasCycle(sourceNode, visited, visiting);
            if (result) {
                return true;
            }
        }
        visited.add(node);
        visiting.remove(node);
        return false;
    }

    public void print() {
        for (Node source : adjacencyList.keySet()) {
            List<Node> adjacent = adjacencyList.get(source);
            System.out.println(source+ " is connected to " + adjacent);
        }
    }
}
