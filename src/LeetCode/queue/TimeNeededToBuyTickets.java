package LeetCode.queue;

public class TimeNeededToBuyTickets {
    public int solutionQ2073(int[] queue, int k) {
        int timeTaken = 0;
        int position = 0;
        int len = queue.length;
        while (queue[k] > 0) {
            if (queue[position%len] > 0) {
                timeTaken++;
                queue[position%len] = queue[position%len] - 1;
            }
            position++;
        }
        return timeTaken;
    }
}
