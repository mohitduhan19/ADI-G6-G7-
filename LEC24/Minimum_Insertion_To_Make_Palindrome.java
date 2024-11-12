package LEC24;
import java.util.*;
public class Minimum_Insertion_To_Make_Palindrome {
    public int helper(String s , String d){
        int[][] dp = new int[s.length()+1][d.length()+1];
        for(int i = 0;i < s.length();i++)dp[i][0] = 0;
        for(int j = 0;j < d.length();j++)dp[0][j] = 0;

        for(int i = 1;i <= s.length();i++){
            for(int j = 1;j <= d.length();j++){
                if(s.charAt(i-1) == d.charAt(j-1))dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[s.length()][d.length()];
    }
    public int minInsertions(String s) {
        int n = s.length();
        int[][]dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i],-1);
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        // return helper(n,n,s,sb.toString(),dp);
        int len= helper(s , sb.toString());
        return s.length()-len;
    }
}
