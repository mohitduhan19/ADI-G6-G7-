package LEC23;

public class Longest_Common_Subsequence {
    /*public int longest(String s1 , String s2 ,int i , int j){
       if(i < 0 || j < 0){
           return 0;
       }
       int[][] dp = new int[s1.length()][s2.length()];
       for(int k  = 0; k < dp.length;k++){
       Arrays.fill(dp[k] , -1);
       }
       if(dp[i][j] != -1)return dp[i][j];
       if(s1.charAt(i) != s2.charAt(j)){
         return Math.max(longest(s1 , s2 , i - 1 , j) , longest(s1 , s2 , i  , j - 1));
       }
       return dp[i][j]  = 1 + longest(s1 , s2 , i - 1 , j - 1);

   }*/
    public int longestCommonSubsequence(String s, String d) {
        // return longest(text1 , text2 , text1.length()-1,text2.length()-1);

        int[][] dp = new int[s.length() + 1][d.length() + 1];
        for(int i = 0; i <= s.length();i++)dp[i][0] = 0;
        for(int j = 0; j <= d.length();j++)dp[0][j] = 0;

        for(int idx = 1; idx <= s.length();idx++){
            for(int x = 1;x <= d.length();x++){
                if(s.charAt(idx - 1) != d.charAt(x - 1)){
                    dp[idx][x] =  Math.max(dp[idx - 1][x] , dp[idx][x - 1]);
                }
                else dp[idx][x]  = 1 + dp[idx - 1][x - 1];
            }
        }
        return dp[s.length()][d.length()];
    }
}
