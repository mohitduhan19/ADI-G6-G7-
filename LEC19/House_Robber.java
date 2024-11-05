package LEC19;

public class House_Robber {
    private Integer[] dp;
    public int help(int[] nums, int curr){
        if(curr >= nums.length)return 0;
        if(dp[curr]!= null)return dp[curr];

        int steal = nums[curr] + help(nums, curr + 2);
        int notSteal= help(nums , curr + 1);
        return dp[curr] = Math.max(steal , notSteal);
    }
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return help(nums , 0);
    }
}
