package Linear;

/*
 * LinkedList Operations Complexity:
 *
 * get(index)          -> O(n)      // Traverse to index
 * set(index, value)   -> O(n)      // Traverse to index
 * insertAtBeginning() -> O(1)      // Head insertion
 * insertAtEnd()       -> O(1) if tail pointer exists, O(n) otherwise
 * insertAtIndex()     -> O(n)      // Traverse to index
 * removeAtBeginning() -> O(1)      // Remove head
 * removeAtEnd()       -> O(n)      // Traverse to second-last node
 * removeAtIndex()     -> O(n)      // Traverse to index
 * search(value)       -> O(n)      // Linear search
 * iterate()           -> O(n)      // Traverse all nodes
 * size()              -> O(1)      // If tracked; O(n) if counting on demand
 */
public class MyLinkedList {
    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public void addFirst(int first) {
        Node newNode = new Node(first);
        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.next = this.first;
            this.first = newNode;
        }

    }

    public void addLast(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;
    }

    public int indexOf(int item) {
        int counter = 0;
        Node current = this.first;
        while (current != null) {
            if (current.value == item) {
                return counter;
            } else {
                counter++;
                current = current.next;
            }
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    private boolean isEmpty() {
        return this.first == null;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        } else {
            Node first = this.first;
            this.first = this.first.next;
            first.next = null;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            return;
        } else {
            Node current = this.first;
            while (current.next != this.last) {
                current = current.next;
            }
            current.next = null;
            this.last = current;
        }
    }
}
