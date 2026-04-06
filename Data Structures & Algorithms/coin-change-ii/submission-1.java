class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[coins.length][amount + 1];
        return count(amount, coins, 0, memo);   
    }

    public int count(int amount, int[] coins, int start, Integer[][] memo){
        if(amount == 0)
            return 1;
        if(start == coins.length)
            return 0;
        if(memo[start][amount] != null)
            return memo[start][amount];
            
        int res = 0;
        for(int i = start; i < coins.length; i++){
            if(amount >= coins[i]){
                res += count(amount - coins[i], coins, i, memo);
            }
        }
        return memo[start][amount] = res;
    }
}
