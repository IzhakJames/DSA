package LeetCode.DP;

public class ClimbingStairs {
    public int solutionQ70(int n) {
        int oneStepBefore = 1;
        int twoStepBefore = 1;
        for (int i = 1; i < n; i++) {
            int nextStep = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = nextStep;
        }
        return oneStepBefore;
    }
}
