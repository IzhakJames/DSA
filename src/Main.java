import Tree.MyTree;

public class Main {
    public static void main(String[] args) {
        MyTree mytree = new MyTree();

        mytree.insert(10);
        mytree.insert(5);
        mytree.insert(15);
        mytree.insert(6);
        mytree.insert(1);
        mytree.insert(8);
        mytree.insert(12);
        mytree.insert(18);
        mytree.insert(17);

//        mytree.insert(20);
//        mytree.insert(10);
//        mytree.insert(30);
//        mytree.insert(6);
//        mytree.insert(21);
//        mytree.insert(4);
//        mytree.insert(3);
//        mytree.insert(8);



//        System.out.println(mytree.isBST());
        System.out.println(mytree);
        System.out.println();
        mytree.getNodesAtKDistance(3);

    }
}