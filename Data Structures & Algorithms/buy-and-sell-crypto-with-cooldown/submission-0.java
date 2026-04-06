class Solution {
    public int maxProfit(int[] prices) {
        int[][] states = new int[prices.length][3];

        states[0][0] = -prices[0];
        states[0][1] = 0;
        states[0][2] = Integer.MIN_VALUE/2;

        for(int i = 1; i < prices.length; i ++){
            states[i][0] = Math.max(states[i-1][0], states[i-1][1] - prices[i]);
            states[i][1] = Math.max(states[i-1][2],states[i-1][1]);
            states[i][2] = prices[i] + states[i-1][0];
        }
        return Math.max(states[prices.length-1][2],Math.max(states[prices.length-1][0],states[prices.length-1][1]));
    }
}
