class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int a = 1; a <= amount; a++){
                dp[a] = dp[a] + (coins[i] <= a ? dp[a - coins[i]] : 0);
            }
        }
        return dp[amount];
    }
}
