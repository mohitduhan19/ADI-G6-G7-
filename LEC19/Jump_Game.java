package LEC19;

public class Jump_Game {
    /* public boolean help(int[] nums , int i){
     if(i == nums.length-1)return true;
     if(nums[i] == 0)return false;

     boolean ans = false;
     for(int k = 1;k <= nums[i];k++){
         boolean l = false;
         if(i + k < nums.length)l = help(nums ,i + k);
         ans = ans || l;
     }
     return ans;
 }*/
    public boolean canJump(int[] nums) {
        // return help(nums , 0);
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1] = true;
        for(int i= nums.length-2;i>=0;i--){
            if(nums[i] == 0)dp[i] = false;
            boolean ans = false;
            for(int k = 1;k <= nums[i];k++){
                boolean l = false;
                if(i + k<nums.length)l = dp[i+k];
                ans = ans || l;
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}
