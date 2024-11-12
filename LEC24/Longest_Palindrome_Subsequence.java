package LEC24;
import java.util.*;
public class Longest_Palindrome_Subsequence {

        // public int helper(int i , int j , String s1 , String s2 , int[][]dp){
        //     if(i == 0 || j == 0) return 0;
        //     if(dp[i][j] != -1) return dp[i][j];

        //     if(s1.charAt(i-1) == s2.charAt(j-1)){
        //         return 1 + helper(i-1,j-1,s1,s2,dp);
        //     }
        //     return dp[i][j] = Math.max(helper(i-1,j,s1,s2,dp),helper(i,j-1,s1,s2,dp));
        // }

        public int helper(String s , String d){
            int[][] dp = new int[s.length() + 1][d.length() + 1];
            for(int i = 0;i < s.length();i++)dp[i][0] = 0;
            for(int j= 0;j < d.length();j++)dp[0][j] = 0;

            for(int i = 1;i <= s.length();i++){
                for(int j = 1;j <= d.length();j++){
                    if(s.charAt(i-1) == d.charAt(j-1))dp[i][j] = 1 + dp[i-1][j-1];
                    else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
            return dp[s.length()][d.length()];
        }
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][]dp = new int[n+1][n+1];
            for(int i = 0; i <= n; i++){
                Arrays.fill(dp[i],-1);
            }
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            // return helper(n,n,s,sb.toString(),dp);
            return helper(s , sb.toString());
        }
    }
