package LEC20;

public class zero_one_Knapsack {
    public int help(int[] wt, int cap, int i, int[] val) {
        if (i == 0) {
            if (wt[0] <= cap) return val[0];
            return 0;
        }

        int notTake = 0 + help(wt, cap, i - 1, val);
        int take = Integer.MIN_VALUE;
        if (wt[i] <= cap) {
            take = val[i] + help(wt, cap - wt[i], i - 1, val);
        }
        return Math.max(take, notTake);
    }
}