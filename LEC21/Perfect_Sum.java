package LEC21;

public class Perfect_Sum {
    static final int MOD = 1000000007;
    public static int countSubsetsWithSum(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - arr[i - 1]]) % MOD;
                }
            }
        }
        return dp[n][sum];
    }

    public int perfectSum(int arr[],int n, int sum)
    {

        return (countSubsetsWithSum(arr, n , sum))%MOD;
    }
}
