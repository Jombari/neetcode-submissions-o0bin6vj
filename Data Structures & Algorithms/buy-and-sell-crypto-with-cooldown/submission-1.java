class Solution {
    public int maxProfit(int[] prices) {
        int[] prevProfit = new int[3];

        prevProfit[0] = -prices[0];
        prevProfit[1] = 0;
        prevProfit[2] = Integer.MIN_VALUE/2;

        for(int i =1; i < prices.length; i++){
            int[] curPrices = new int[3];
            curPrices[0] = Math.max(prevProfit[0], prevProfit[1] - prices[i]);
            curPrices[1] = Math.max(prevProfit[1],prevProfit[2]);
            curPrices[2] = prevProfit[0] + prices[i];

            prevProfit[0] = curPrices[0];
            prevProfit[1] = curPrices[1];
            prevProfit[2] = curPrices[2];
        }

        return Math.max(prevProfit[1],prevProfit[2]);

    }

}
