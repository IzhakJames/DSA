
import Linear.util.ExpressionBalancer;
import Linear.util.StringReverser;

public class Main {
    public static void main(String[] args) {
        String input = "abcdefghij";
        System.out.println(StringReverser.reverseUsingStack(input));
        System.out.println(StringReverser.reverseWithoutStack(input));

        String expressions = "[(";
        System.out.println(ExpressionBalancer.isBalance(expressions));

    }
}