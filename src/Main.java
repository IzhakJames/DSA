import Linear.MyMinPriorityQueue;

public class Main {
    public static void main(String[] args) {
        MyMinPriorityQueue queue = new MyMinPriorityQueue(10);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(15);
        queue.enqueue(30);
        queue.enqueue(25);
        queue.enqueue(5);
        queue.enqueue(10);
        System.out.println(queue);
    }
}