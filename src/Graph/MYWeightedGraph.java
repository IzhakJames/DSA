package Graph;

import java.util.*;

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

    public void print() {
        for (Node source : nodes.values()) {
            List<Edge> adjacent = source.getEdges();
            System.out.println(source+ " is connected to " + adjacent);
        }
    }
}
