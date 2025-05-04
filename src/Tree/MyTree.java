package Tree;

public class MyTree {
    private class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node="+value;
        }
    }
    private Node root;
    private int size = 0;

    public MyTree() {
        root = new Node(0);
    }

    public MyTree(int value) {
        root = new Node(value);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                if (value < current.value) {
                    if (current.left == null) {
                        current.left = newNode;
                        break;
                    }
                    current = current.left;

                } else {
                    if (current.right == null) {
                        current.right =newNode;
                        break;
                    }
                    current = current.right;
                }
            }
        }
        size++;
    }

    public boolean find(int value) {
        Node current = root;
        while(current != null) {
            if (value == current.value) {
                return true;
            } else if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public void traversePreOrderRecursive() {
        traversePreOrderRecursive(root);
    }

    private void traversePreOrderRecursive(Node node) {
        System.out.print(node.value + " ");
        if (node.left != null) {
            traversePreOrderRecursive(node.left);
        }
        if (node.right != null) {
            traversePreOrderRecursive(node.right);
        }
    }

    public void traversePostOrderRecursive() {
        traversePostOrderRecursive(root);
    }

    private void traversePostOrderRecursive(Node node) {
        if (node.left != null) {
            traversePostOrderRecursive(node.left);
        }
        if (node.right != null) {
            traversePostOrderRecursive(node.right);
        }
        System.out.print(node.value + " ");
    }

    public void traverseInOrderRecursive() {
        traverseInOrderRecursive(root);
    }

    private void traverseInOrderRecursive(Node node) {
        if (node.left != null) {
            traverseInOrderRecursive(node.left);
        }
        System.out.print(node.value + " ");
        if (node.right != null) {
            traverseInOrderRecursive(node.right);
        }
    }

    @Override
    public String toString() {
        return buildTreeString(root, "", true, ""); // root has no label
    }

    //Something like a Pre-order traversal
    private String buildTreeString(Node node, String prefix, boolean isTail, String label) {
        if (node == null) return "";

        StringBuilder builder = new StringBuilder();

        builder.append(prefix)
                .append(isTail ? "└── " : "├── ")
                .append(node.value);

        if (!label.isEmpty()) {
            builder.append(" (").append(label).append(")");
        }

        builder.append("\n");

        boolean hasLeft = node.left != null;
        boolean hasRight = node.right != null;

        if (hasLeft || hasRight) {
            if (node.left != null)
                builder.append(buildTreeString(node.left, prefix + (isTail ? "    " : "│   "), !hasRight, "L"));
            if (node.right != null)
                builder.append(buildTreeString(node.right, prefix + (isTail ? "    " : "│   "), true, "R"));
        }

        return builder.toString();
    }
}
