package Tree;

public class MyAVLTree {
    private class AVLNode {
        int value;
        AVLNode left;
        AVLNode right;
        int height;
        public AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(value, root);
    }

    private AVLNode insert(int value, AVLNode node) {
        if (node == null) {
            node = new AVLNode(value);
        } else {
            if (value < node.value) {
                node.left = insert(value, node.left);
            } else {
                node.right = insert(value, node.right);
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // balanceFactor = h(L) - h(R)
        int balanceFactor = height(node.left) - height(node.right);
        if (balanceFactor > 1) {
            System.out.println(node.value + " is left Heavy");
        } else if (balanceFactor < -1) {
            System.out.println(node.value + " is right Heavy");
        }

        return node;
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }

//    private boolean isLeftHeavy(AVLNode node) {
//        return height(node.left) - height(node.right)  > 1;
//    }
//
//    private boolean isRightHeavy(AVLNode node) {
//        return height(node.left) - height(node.right)  > -1;
//    }

    @Override
    public String toString() {
        return buildTreeString(root, "", true, ""); // root has no label
    }

    //Something like a Pre-order traversal
    private String buildTreeString(AVLNode node, String prefix, boolean isTail, String label) {
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
