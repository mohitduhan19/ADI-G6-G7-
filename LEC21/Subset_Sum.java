//package LEC21;
//import java.util.*;
//public class Subset_Sum {
//    public boolean help(int[]nums, int tar , int i , int[][] dp){
//        if(tar == 0)return true;
//
//        if(i == 0)return nums[0] == tar;
//
//        if(dp[i][tar] != -1)return dp[i][tar];
//        boolean notTaken = help(nums , tar , i-1 , dp);
//
//        boolean taken = false;
//        if(nums[i] <= tar){
//            taken = help(nums , tar-nums[i] , i-1 , dp);
//        }
//        return dp[i][tar] = notTaken || taken;
//    }
//    public int solve(int[] nums, int target) {
//        int[][] dp = new int[nums.length][target + 1];
//        for(int[] rows : dp){
//            Arrays.fill(rows , -1);
//        }
//
//        boolean ans = help(nums , target ,nums.length -1 ,dp);
//        if(ans == false)return 0;
//        return 1;
//    }
//}
