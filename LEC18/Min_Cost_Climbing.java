package LEC18;

public class Min_Cost_Climbing {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i <= cost.length;i++){
            int right = Integer.MAX_VALUE;
            int left = dp[i - 1] + cost[i - 1];

            right =  dp[i - 2] + cost[i - 2];

            dp[i] =  Math.min(left , right);
        }
        return dp[cost.length];
    }}
