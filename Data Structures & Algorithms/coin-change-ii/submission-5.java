class Solution {
    public int change(int amount, int[] coins) {
        int[] combos = new int[amount+1];
        combos[0] = 1;

        for(int coin : coins){
            for(int i = 1; i <= amount; i++){
                combos[i] += (coin <= i ? combos[i - coin] : 0);
            }
        }
        return combos[amount];
    }
}
