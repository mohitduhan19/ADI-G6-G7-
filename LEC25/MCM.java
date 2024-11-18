package LEC25;

public class MCM {
    // static int help(int i , int j , int arr[],int[][] dp){
    //     if(i == j)return 0;
    //     int min = Integer.MAX_VALUE;

    //     if(dp[i][j] != -1)return dp[i][j];
    //     for(int k = 1;k < j;k++){
    //         int steps = arr[i-1]*arr[k]*arr[j] + help(i , k , arr , dp) +help(k+1 , j , arr , dp);
    //         if(steps <min)min = steps;
    //     }
    //     return dp[i][j] = min;
    // }
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp = new int[N][N];
        for(int[] row: dp){
            Arrays.fill(row , -1);
        }
        //return help(1 , N-1 , arr , dp);
        for(int i = 1;i < N;i++)dp[i][i] = 0;

        for(int i = N-1;i >= 1;i--){
            for(int j = i + 1;j <  N;j++){
                int min = Integer.MAX_VALUE;
                for(int k = i;k < j;k++){
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] +dp[k+1][ j];
                    if(steps <min)min = steps;
                }
                dp[i][j] = min;
            }
        }
        return dp[1][N-1];
    }
}
