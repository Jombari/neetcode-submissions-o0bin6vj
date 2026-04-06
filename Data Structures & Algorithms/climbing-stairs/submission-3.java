class Solution {
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        int[] combos = new int[n+1];
        combos[1] = 1;
        combos[2] = 2;
        for(int i = 3; i <=n ; i++){
            combos[i] = combos[i-1] + combos[i-2];
        } 
        return combos[n];
    }
}
