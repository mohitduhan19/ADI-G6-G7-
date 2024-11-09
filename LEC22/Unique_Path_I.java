package LEC22;

public class Unique_Path_I {
    /* public int help(int i , int j){
        if(i == 0 && j== 0)return 1;
        if(i < 0 || j < 0)return 0;

        int left = help(i , j - 1);
        int right = help(i-1 , j);
        return left + right;
    }*/
    public int uniquePaths(int m, int n) {
        // return help(m-1 , n-1);
        int[][] dp = new int[m][n];

        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++){
                if(i == 0 && j == 0)dp[0][0] = 1;
                else{
                    int left = 0 , right = 0;
                    if(j > 0)left = dp[i][j-1];
                    if(i > 0)right = dp[i-1][j];
                    dp[i][j] = left + right;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
