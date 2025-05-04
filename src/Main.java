import Tree.MyTree;

public class Main {
    public static void main(String[] args) {
        MyTree mytree = new MyTree();
//        mytree.insert(10);
//        mytree.insert(5);
//        mytree.insert(15);
//        mytree.insert(6);
//        mytree.insert(1);
//        mytree.insert(8);
//        mytree.insert(12);
//        mytree.insert(18);
//        mytree.insert(17);
        mytree.insert(7);
        mytree.insert(4);
        mytree.insert(9);
        mytree.insert(1);
        mytree.insert(6);
        mytree.insert(8);
        mytree.insert(10);
        System.out.println("Preorder traversal of the tree");
        mytree.traversePreOrderRecursive();
        System.out.println("\nPostorder traversal of the tree");
        mytree.traversePostOrderRecursive();
        System.out.println("\nLevel order traversal of the tree");
        mytree.traverseInOrderRecursive();

    }
}