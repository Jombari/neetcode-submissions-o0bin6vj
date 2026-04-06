class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] coinsNeeded = new int[amount+1];
        int max = amount +1;
        Arrays.fill(coinsNeeded, max);
        coinsNeeded[0] = 0;
        for(int coin : coins){
            for(int i = 1; i <=amount ; i++){
                if(coin > i)
                    continue;
                coinsNeeded[i] = Math.min(coinsNeeded[i-coin] +1,coinsNeeded[i]);
            }            
        }
        if(coinsNeeded[amount] == max)
            return  -1;
        return coinsNeeded[amount];
    }
}
