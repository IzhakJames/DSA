import Tree.MyAVLTree;
import Tree.MyMaxHeap;
import Tree.MyTree;

public class Main {
    public static void main(String[] args) {
        MyMaxHeap heap = new MyMaxHeap(10);
        heap.insert(15);
        heap.insert(10);
        heap.insert(3);
        heap.insert(8);
        heap.insert(12);
        heap.insert(9);
        heap.insert(4);
        heap.insert(1);
        heap.insert(24);
        System.out.println(heap);
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        System.out.println(heap);

    }
}