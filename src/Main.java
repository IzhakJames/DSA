import Tree.MyAVLTree;
import Tree.MyMaxHeap;
import Tree.MyTree;

public class Main {
    public static void main(String[] args) {
        MyMaxHeap heap = new MyMaxHeap(1);
        heap.insert(15);
        System.out.println(heap);
        heap.remove();
        System.out.println(heap);

    }
}