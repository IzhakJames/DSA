package LeetCode.arrays;

public class MinimumTimeVisitingAllPoints {
    public int solutionQ1266(int[][] points) {
        int timeTaken = 0;
        for (int i = 1; i < points.length; i++) {
            int x1 = points[i-1][0];
            int y1 = points[i-1][1];

            int x2 = points[i][0];
            int y2 = points[i][1];

            int horizontalDist = Math.abs(x2-x1);
            int verticalDist = Math.abs(y2-y1);

            timeTaken += Math.max(horizontalDist, verticalDist);
        }

        return timeTaken;
    }
}
