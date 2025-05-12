package Graph;

import java.util.*;

public class MyWeightedGraph {

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

    private class NodeEntry {
        Node node;
        int priority;
        private NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public int getShortestDistance(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException("Node " + from + " does not exist");
        }

        HashMap<Node, Integer> distances = new HashMap<>();
        for (Node source : nodes.values()) {
            distances.put(source, Integer.MAX_VALUE);
        }
        distances.replace(fromNode,0);

        Map<Node, Node> previousNodes = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> pq = new PriorityQueue<NodeEntry>(
                Comparator.comparingInt(ne -> ne.priority)
        );

        pq.offer(new NodeEntry(fromNode, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll().node;
            visited.add(current);
            for (Edge edge : current.getEdges()) {
                if (!visited.contains(edge.to)) {
                    int newDist = distances.get(current) + edge.weight;
                    if (newDist < distances.get(edge.to)) {
                        distances.replace(edge.to, newDist);
                        previousNodes.put(edge.to, current);
                        pq.offer(new NodeEntry(edge.to, newDist));
                    }
                }

            }
        }

        // Print out the path
        Stack<Node> stack = new Stack<>();
        Node current = nodes.get(to);
        if  (current == null) {
            throw new IllegalArgumentException("Node " + to + " does not exist");
        }
        while (current != null) {
            stack.push(current);
            current = previousNodes.get(current);
        }

        StringBuilder path = new StringBuilder();
        while (!stack.isEmpty()) {
            path.append(stack.pop());
            if (!stack.isEmpty()) path.append(" -> ");
        }
        System.out.println(path.toString());

        return distances.get(nodes.get(to));
    }

    public boolean hasCycle() {
        HashSet<Node> visited = new HashSet<>();
        // Need to loop through all the loops in case it is an undirected graph with two separate sections
        for (Node node :  nodes.values()) {
            if (!visited.contains(node)) {
                if (hasCycle(node, visited, node)) return true;
            }
        }

        return false;
    }

    private boolean hasCycle(Node node, HashSet<Node> visited, Node parent) {
        if (visited.contains(node)) return true;
        visited.add(node);
        for (Edge edge : node.getEdges()) {
            if (!edge.to.equals(parent))
                if (hasCycle(edge.to, visited, node)) return true;
        }
        return false;
    }

    public MyWeightedGraph getMinimumSpanningTree() {
        if (nodes.isEmpty()) return null;

        MyWeightedGraph graph = new MyWeightedGraph();
        PriorityQueue<Edge> edges = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.weight)
        );

        Node first = nodes.values().iterator().next();
        edges.addAll(first.getEdges());
        graph.addNode(first.label);
        while (graph.nodes.size() < nodes.size()) {
            if (edges.isEmpty()) {
                return graph;
            }
            Edge edge = edges.poll(); // Minimum edge
            Node minNode = edge.to;
            if (graph.containsNode(minNode.label)) {
                continue;
            }
            graph.addNode(minNode.label);
            graph.addEdge(edge.from.label, minNode.label, edge.weight);
            for (Edge nextEdge : minNode.getEdges()) {
                if (!graph.containsNode(nextEdge.to.label)) {
                    edges.add(nextEdge);
                }
            }
        }

        return graph;
    }

    public boolean containsNode(String label) {
        return nodes.containsKey(label);
    }

    public void print() {
        if (nodes.isEmpty()) return;
        for (Node source : nodes.values()) {
            List<Edge> adjacent = source.getEdges();
            System.out.println(source+ " is connected to " + adjacent);
        }
    }
}
