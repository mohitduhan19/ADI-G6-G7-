package LEC21;

public class Minimum_Path_Sun {
    /*public int minsum(int[][] nums , int i , int j){
       if(i == 0 && j == 0){
           return nums[0][0];
       }
       int l = Integer.MAX_VALUE , r = Integer.MAX_VALUE;
       if(j > 0) l = nums[i][j] + minsum(nums , i , j- 1);
       if(i > 0) r = nums[i][j] + minsum(nums , i - 1,j);
       return Math.min(l,r);
   }*/
    public int minPathSum(int[][] nums) {
        //return minsum(nums , nums.length-1 , nums[0].length-1);
        int[][] dp = new int[nums.length][nums[0].length];

        for(int i = 0; i < nums.length;i++){
            for(int j = 0;j < nums[0].length;j++){
                if(i == 0 && j == 0)dp[i][j] = nums[0][0];
                else{
                    int l = Integer.MAX_VALUE , r = Integer.MAX_VALUE;
                    if(j > 0) l = nums[i][j] + dp[i][j-1];
                    if(i > 0) r = nums[i][j] + dp[i-1][j];
                    dp[i][j] = Math.min(l ,r);
                }
            }
        }
        return dp[nums.length-1][nums[0].length-1];
    }
}
