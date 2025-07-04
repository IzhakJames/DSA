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
        setHeight(node);
        node = balance(node);


        return node;
    }
    private void setHeight(AVLNode node) {
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private AVLNode balance(AVLNode node) {
        if (node == null) {
            return null;
        }
        // balanceFactor = h(L) - h(R)
        if (isLeftHeavy(node)) { // > 1
            System.out.println(node.value + " is left Heavy");
            if (balanceFactor(node.left) < 0) {
                System.out.println(node.left.value + " rotate left");
                node.left = rotateLeft(node.left);
            }
            System.out.println(node.value + " rotate right");
            node = rotateRight(node);

        } else if (isRightHeavy(node)) { // -1
            System.out.println(node.value + " is right Heavy");
            if (balanceFactor(node.right) > 0) {
                System.out.println(node.right.value + " rotate right");
                node.right = rotateRight(node.right);
            }
            System.out.println(node.value + " rotate left");
            node = rotateLeft(node);
        }
        return node;
    }

    private int getHeight(AVLNode node) {
        return node == null ? -1 : node.height;
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node)  > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node)  < -1;
    }

    private AVLNode rotateLeft(AVLNode node) {
        AVLNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode node) {
        AVLNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }
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
