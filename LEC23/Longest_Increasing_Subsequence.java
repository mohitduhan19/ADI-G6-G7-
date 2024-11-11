package LEC23;

public class Longest_Increasing_Subsequence {
    // publi int help(int[] nums , int i ,int prev){
    // if(nums.length ==0)return 0;

    // int take = Integer.MIN_VALUE;
    // if(nums[i] > prev){
    // take = 1 + help(nums , i + 1 , nums[i]);
    // }
    // int notTake = help(nums , i + 1 , prev);
    // return Math.max(take , notTake);
    // }
    public int lengthOfLIS(int[] nums) {
        // return help(nums , 0 , Integer.MIN_VALUE);
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int overallMax = 0;

        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max;
            if (dp[i] > overallMax)
                overallMax = dp[i];
        }
        return overallMax;
    }
}
