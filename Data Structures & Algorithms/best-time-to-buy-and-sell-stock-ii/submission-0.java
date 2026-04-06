class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

    private int rec(int[] prices, int i,int bought, int[][] dp){
        if( i== prices.length){
            return 0;
        }

        if (dp[i][bought] != -1){
            return dp[i][bought];
        }
        int res = rec(prices, i + 1, bought, dp);
        if(bought == 1) {
            res = Math.max(res,prices[i] + rec(prices, i+ 1, 0, dp));
        } else {
            res = Math.max(res, -prices[i] + rec(prices, i+1,1,dp));
        }
        dp[i][bought] = res;
        return res;
    }
}