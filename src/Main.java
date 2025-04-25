import Linear.MyArray;
import Linear.MyLinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        int output1 = list.getKthNodeFromEndWithSize(4);
        int output2 = list.getKthNodeFromEnd(4);
        System.out.println(output1);
        System.out.println(output2);


    }
}