
import Linear.MyArrayQueue;
import Linear.util.QueueReverser;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        MyArrayQueue q = new MyArrayQueue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        int front = q.dequeue();
        q.enqueue(5);
        q.enqueue(6);
        q.dequeue();
        q.enqueue(7);
        System.out.println(q);

    }
}