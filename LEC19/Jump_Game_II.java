package LEC19;

public class Jump_Game_II {
    /* public int help(int[] nums ,int i){
       if(i== nums.length-1)return 0;
       if(nums[i] == 0)return 1001;

      int[] dp = new int[nums.length];
      Arrays.fill(dp  , -1);
      if(dp[i] != -1)return dp[i];
       int ans = Integer.MAX_VALUE;
       for(int k = 1;k <= nums[i];k++){
           int l = Integer.MAX_VALUE;
           if(i+k<nums.length)l= 1+ help(nums , i +k);
           ans = Math.min(ans , l);
       }
       return dp[i] = ans;
   }*/
    public int jump(int[] nums) {
        //  return help(nums , 0);
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for(int i = nums.length-2;i>=0;i--){
            int ans = Integer.MAX_VALUE;
            if(nums[i] == 0){
                dp[i] = 1001;
                continue;
            }

            for(int k = 1;k <= nums[i];k++){
                int l = Integer.MAX_VALUE;
                if(i + k<nums.length)l= 1 + dp[i+k];
                ans = Math.min(ans , l);
            }
            dp[i] = ans;

        }
        return dp[0];
    }
}
