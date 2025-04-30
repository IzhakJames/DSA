import Linear.MyArray;
import Linear.MyLinkedList;
import Linear.util.StringReverser;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String input = "abcdefghij";
        System.out.println(StringReverser.reverseUsingStack(input));
        System.out.println(StringReverser.reverseWithoutStack(input));

    }
}