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
            newNode.setNext(this.first);
            this.first = newNode;
        }

    }

    public void addLast(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }
    }

    public int indexOf(int item) {
        int counter = 0;
        Node current = this.first;
        while (current != null) {
            if (current.getValue() == item) {
                return counter;
            } else {
                counter++;
                current = current.getNext();
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

    //deleteFirst
    //deleteLast
}
