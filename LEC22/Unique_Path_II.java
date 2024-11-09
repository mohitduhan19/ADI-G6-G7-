package LEC22;

public class Unique_Path_II {
    /* public int help(int[][] nums , int i , int j){
       if(i < 0 || j < 0)return 0;
       if(nums[i][j] == 1)return 0;
       if(i == 0 && j == 0)return 1;

       int left = help(nums , i , j - 1);
       int right = help(nums , i-1 ,j);
       return left + right;
   }*/
    public int uniquePathsWithObstacles(int[][] nums) {
        // return help(nums , nums.length-1  ,nums[0].length-1);
        int[][] dp= new int[nums.length][nums[0].length];

        if(nums[0][0] == 1)return 0;

        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < nums[0].length;j++){
                if(i == 0 &&j ==0)dp[i][j] = 1;
                else{
                    int left = 0 , right = 0;
                    if(nums[i][j] != 1){
                        if(j > 0)left = dp[i][j-1];
                        if(i > 0)right = dp[i-1][j];
                        dp[i][j] = left + right;
                    }
                }
            }
        }
        return dp[nums.length-1][nums[0].length-1];
    }
}
