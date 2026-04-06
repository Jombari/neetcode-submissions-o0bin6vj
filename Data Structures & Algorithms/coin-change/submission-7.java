public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount+1];
        Arrays.fill(res,1001);
        res[0] = 0;

        for(int i = 0; i < coins.length; i ++){
            for(int a = 1; a <= amount; a++){
                if(coins[i] <= a){
                    res[a] = Math.min(res[a], res[a-coins[i]]+1);
                }
            }
        }
        return res[amount] > 1000? -1 :res[amount];
    }
}