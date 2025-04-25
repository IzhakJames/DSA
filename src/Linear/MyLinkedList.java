package Linear;

import java.util.NoSuchElementException;

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
    private int size;

    public int getFirst() {
        return first.value;
    }

    public int getLast() {
        return last.value;
    }

    public void addFirst(int first) {
        Node newNode = new Node(first);
        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.next = this.first;
            this.first = newNode;
            size++;
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
        size++;
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
            throw new NoSuchElementException();
        } else {
            if (this.first == this.last) {
                this.first = null;
                this.last = null;
            } else {
                Node first = this.first;
                this.first = this.first.next;
                first.next = null;
            }
            size--;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            if (this.first == this.last) {
                this.first = null;
                this.last = null;
            } else {
                Node current = this.first;
                // Traverse to the second last node
                while (current.next != this.last) {
                    current = current.next;
                }
                current.next = null;
                this.last = current;
            }
            size--;
        }
    }

    public int size() {
        return this.size;
    }

    public int[] toArray() {
        int[] array = new int[this.size()];
        Node current = this.first;
        for (int i = 0; i < this.size(); i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) {
            return; // Changed this from throwing exception
        }

        if (this.size == 1) {
            return;
        }

        Node current = this.first;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.last = this.first;
        this.first = prev;
    }

    public int getKthNodeFromEndWithSize(int k) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (k > this.size() || k <= 0) {
            throw new IllegalArgumentException("K-th node is not within the size of list");
        }
        if (k == this.size()) {
            return this.first.value;
        }
        if (k == 1) {
            return this.last.value;
        }
        int loopCounter = this.size - k + 1;
        Node current = this.first;

        for (int i = 1; i < loopCounter; i++) {
            current = current.next;
        }
        return current.value;
    }

    /*
    * This method is for cases where size() is unknown
    * */
    public int getKthNodeFromEnd(int k) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (k > this.size() || k <= 0) {
            throw new IllegalArgumentException("K-th node is not within the size of list");
        }
        if (k == 1) {
            return this.last.value;
        }
        Node point1 = this.first;
        Node point2 = this.first;
        for (int i = 1; i < k; i++) {
            point2 = point2.next;
        }
        while (point2 != this.last) {
            point1 = point1.next;
            point2 = point2.next;
        }
        return point1.value;


    }
}
