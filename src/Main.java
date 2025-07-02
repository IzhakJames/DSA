
import LeetCode.queue.TimeNeededToBuyTickets;
import LeetCode.tree.ConstructBinaryTree;


public class Main {
    public static void main(String[] args) {
        TimeNeededToBuyTickets solution = new TimeNeededToBuyTickets();
        int[] A = {5,1,1,1};
        int[] B = {3,2,1};
        int node = solution.solutionQ2073(A,0);
        System.out.println(node);
        System.out.println("End");

    }

}