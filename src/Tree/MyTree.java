package Tree;

/*
For testing purpose
Tree 1
mytree.insert(10);
mytree.insert(5);
mytree.insert(15);
mytree.insert(6);
mytree.insert(1);
mytree.insert(8);
mytree.insert(12);
mytree.insert(18);
mytree.insert(17);

Tree 2
mytree.insert(20);
mytree.insert(10);
mytree.insert(30);
mytree.insert(6);
mytree.insert(14);
mytree.insert(24);
mytree.insert(3);
mytree.insert(8);
mytree.insert(26);

Tree 3
mytree.insert(7);
mytree.insert(4);
mytree.insert(9);
mytree.insert(1);
mytree.insert(6);
mytree.insert(8);
mytree.insert(10);

 */

import java.util.ArrayList;
import java.util.List;

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
            return "Node=" + value;
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

    public int size() {
        return size;
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
                        current.right = newNode;
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
        while (current != null) {
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

    public boolean areSiblings(int value1, int value2) {
        return areSiblings(value1, value2, root);
    }

    private boolean areSiblings(int value1, int value2, Node node) {
        if (node == null) {
            return false;
        }
        if (node.left != null && node.right != null) {
            if (node.left.value == value1 && node.right.value == value2
                    || node.left.value == value2 && node.right.value == value1){
                return true;
            };
        }

        boolean left = areSiblings(value1, value2, node.left);
        boolean right = areSiblings(value1, value2, node.right);

        return left || right;
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

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);

    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return -1; // height of empty tree = -1

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int maxHeight = Math.max(leftHeight, rightHeight);

        return maxHeight + 1;
    }

    public int findMin() {
        return findMin(root);
    }

    private int findMin(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int left = findMin(node.left);
        int right = findMin(node.right);
        int childMin = Math.min(left, right);
        return Math.min(childMin, node.value);
    }

    public int findMax() {
        return findMax(root);
    }

    private int findMax(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int left = findMax(node.left);
        int right = findMax(node.right);
        int childMax = Math.max(left, right);
        return Math.max(childMax, node.value);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }
    private boolean contains(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        if (node.value < value) {
            return contains(node.left, value);
        } else  {
            return contains(node.right, value);
        }
    }

    public int delete(int value) {
        return delete(value, root).value;
    }

    private Node delete(int value, Node node) {
        if (node == null) {
            return null;
        }
        if (value < node.value) {
            node.left = delete(value, node.left);
        } else if  (value > node.value) {
            node.right = delete(value, node.right);
        } else {
            // Case 1: No child
            if (node.left == null && node.right == null) {
                return null;
            }
            // Case 2 : 1 child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            // Case 3: Two child
            Node successor = findMinNode(node.right); // min node is extreme left for BST
            node.value = successor.value;
            node.right = delete(successor.value, node.right); // delete successor
        }
        size--;
        return node;
    }

    private Node findMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;

    }

    public boolean equals(MyTree tree) {
        if (tree == null) return false;
        return equals(tree.root, this.root);
    }

    private boolean equals(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {
            boolean rootEqual = node1.value == node2.value;

            boolean leftEqual = equals(node1.left, node2.left);
            boolean rightEqual = equals(node1.right, node2.right);
            return rootEqual && leftEqual && rightEqual;
        }
        return false;
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int min, int max) {
        if (node == null) return true;
        if (node.value < min || node.value > max) {
            return false;
        }
        boolean leftBST = isBST(node.left, min, node.value);
        boolean rightBST = isBST(node.right, node.value, max);
        return leftBST && rightBST;
    }

    public void getNodesAtKDistance(int k) {
        List<Integer> list = new ArrayList<>();
        getNodesAtKDistance(k, root, list);
        System.out.println(list);
    }

    private void getNodesAtKDistance(int k, Node node, List<Integer> list) {
        if (node == null) return;
        if (k == 0) {
            list.add(node.value);
            return;
        }
        getNodesAtKDistance(k - 1, node.left, list);
        getNodesAtKDistance(k - 1, node.right, list);
    }

    // Only use to swap child nodes in order to test BST algo
    public void swapRoots() {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public List<Integer> getAncestors(int value) {
        return getAncestors(value, root);
    }

    private List<Integer> getAncestors(int value, Node node) {
        List<Integer> ancestors = new ArrayList<>();

        if (node == null) return new ArrayList<>();

        if (node.value > value) {
            if (node.left != null) {
                if (node.left.value == value) {
                    ancestors.add(node.value);
                } else {
                    ancestors.addAll(getAncestors(value, node.left));
                }
                if (ancestors.contains(node.left.value)) {
                    ancestors.add(node.value);
                }
            }
        }
        if (node.value < value) {
            if (node.right != null) {
                if (node.right.value == value) {
                    ancestors.add(node.value);
                } else {
                    ancestors.addAll(getAncestors(value, node.right));
                }
                if (ancestors.contains(node.right.value)) {
                    ancestors.add(node.value);
                }
            }
        }
        return ancestors;
    }


    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalance(node.left) && isBalance(node.right);

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
