package LEC20;

public class Best_Time_to_buy_stock_cooldown {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 2][2];
        dp[prices.length][0] = dp[prices.length][1] = dp[prices.length+1][0] = dp[prices.length+1][1] = 0;

        for(int i = prices.length-1;i >= 0;i--){
            for(int buy = 0; buy <= 1;buy++){
                int profit = 0;
                if(buy == 1){
                    profit= Math.max((-prices[i] + dp[i + 1][0]), dp[i + 1][1]);
                }
                else profit= Math.max((prices[i] + dp[i + 2][1]) , dp[i + 1][0]);
                dp[i][buy] =  profit;
            }
        }
        return dp[0][1];
    }
}
