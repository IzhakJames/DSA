package LeetCode.tree;

import Linear.util.PairCounters;

import java.util.Arrays;

public class ConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTreePreOrderInOrder(int[] preorder, int[] inorder) {

        if (preorder.length == 1 || inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        int rootVal = preorder[0];
        TreeNode rootNode = new TreeNode(rootVal);
        int rootIndexInOrder = 0;

        while (inorder[rootIndexInOrder] != rootVal) {
            rootIndexInOrder++;
        }

        if (rootIndexInOrder != 0) { // have left child
            rootNode.left = buildTreePreOrderInOrder(
                    Arrays.copyOfRange(preorder, 1, rootIndexInOrder+1),
                     Arrays.copyOfRange(inorder,0,rootIndexInOrder));
        }

        if (rootIndexInOrder != inorder.length-1) { // have right child
            rootNode.right = buildTreePreOrderInOrder(
                    Arrays.copyOfRange(preorder, rootIndexInOrder+1, preorder.length),
                    Arrays.copyOfRange(inorder, rootIndexInOrder+1, inorder.length)
            );
        }

        return rootNode;
    }

    public TreeNode buildTreeInOrderPostOrder(int[] inorder, int[] postorder) {
        if (inorder.length == 1 || postorder.length == 1) {
            return new TreeNode(inorder[0]);
        }

        int rootVal = postorder[postorder.length-1];
        TreeNode rootNode = new TreeNode(rootVal);

        int rootIndexInOrder = 0;
        while (inorder[rootIndexInOrder] != rootVal) {
            rootIndexInOrder++;
        }
        if (rootIndexInOrder != 0) {
            rootNode.left = buildTreePreOrderInOrder(
                    Arrays.copyOfRange(inorder, 0, rootIndexInOrder),
                    Arrays.copyOfRange(postorder,0, rootIndexInOrder));
        }

        if (rootIndexInOrder != inorder.length-1) { // have right child
            rootNode.right = buildTreePreOrderInOrder(
                    Arrays.copyOfRange(inorder, rootIndexInOrder+1, inorder.length),
                    Arrays.copyOfRange(postorder, rootIndexInOrder, postorder.length-1)
            );
        }

        return rootNode;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 1 || postorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int rootVal = preorder[0];
        TreeNode rootNode = new TreeNode(rootVal);

        int leftRoot = preorder[1];
        int rightRoot = postorder[postorder.length-2];

        if (leftRoot == rightRoot) { // only 1 child;
            rootNode.left = constructFromPrePost(
                    Arrays.copyOfRange(preorder, 1, preorder.length),
                    Arrays.copyOfRange(postorder, 0, postorder.length-1)
            );
        } else {
            int leftRootIndex = 0;
            while (postorder[leftRootIndex] != leftRoot) {
                leftRootIndex++;
            }

            int rightRootIndex = 0;
            while (preorder[rightRootIndex] != rightRoot) {
                rightRootIndex++;
            }

            rootNode.left = constructFromPrePost(
                    Arrays.copyOfRange(preorder, 1, rightRootIndex),
                    Arrays.copyOfRange(postorder, 0, leftRootIndex+1)
            );

            rootNode.right = constructFromPrePost(
                    Arrays.copyOfRange(preorder, rightRootIndex, preorder.length),
                    Arrays.copyOfRange(postorder, leftRootIndex+1, postorder.length-1)
            );
        }
        return rootNode;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        };
        int rootVal = preorder[0];
        TreeNode rootNode = new TreeNode(rootVal);

        int partition = 1;
        while (partition < preorder.length && preorder[partition] < rootVal) {
            partition++;
        }
        if (partition != 1) { // there is left tree
            rootNode.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, partition));
        }

        if (partition != preorder.length) { // there is right tree
            rootNode.right = bstFromPreorder(Arrays.copyOfRange(preorder, partition, preorder.length));
        }
        return rootNode;
    }
}

