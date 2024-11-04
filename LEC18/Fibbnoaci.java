package LEC18;
import java.util.*;
public class Fibbnoaci {
    public int fib(int n) {
        if(n == 0)return 0;
        if(n == 1)return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);

        if(dp[n] != -1)return dp[n];
        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }
}
