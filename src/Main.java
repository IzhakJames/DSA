
import LeetCode.tree.ConstructBinaryTree;


public class Main {
    public static void main(String[] args) {
        ConstructBinaryTree solution = new ConstructBinaryTree();
        int[] A = {1,2,3};
        int[] B = {3,2,1};
        ConstructBinaryTree.TreeNode node = solution.buildTreePreOrderInOrder(A,B);
        System.out.println(node);
        System.out.println("End");

    }

}