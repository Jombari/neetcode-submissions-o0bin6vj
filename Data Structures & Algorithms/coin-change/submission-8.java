class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] coinsNeeded = new int[amount+1];
        Arrays.fill(coinsNeeded, Integer.MAX_VALUE/2);
        coinsNeeded[0] = 0;
        for(int coin : coins){
            for(int i = 1; i <=amount ; i++){
                if(coin > i)
                    continue;
                coinsNeeded[i] = Math.min(coinsNeeded[i-coin] +1,coinsNeeded[i]);
            }            
        }
        if(coinsNeeded[amount] == Integer.MAX_VALUE/2)
            return  -1;
        return coinsNeeded[amount];
    }
}
