package LEC20;

public class Coin_Change_2 {
    public int change(int amount, int[] nums) {
        int[][] dp = new int[nums.length][amount+1];
        for(int t = 0; t <= amount;t++){
            if(t%nums[0] == 0)dp[0][t] = 1;
            else dp[0][t] = 0;
        }

        for(int i = 1; i < nums.length;i++){
            for(int k = 0; k <= amount;k++){
                int l = 0;
                if(k >= nums[i])l = dp[i][k - nums[i]];
                int r = dp[i-1][k];
                dp[i][k] = l + r;
            }
        }
        return dp[nums.length-1][amount];
    }
}
