class Solution {
    public int climbStairs(int n) {
        if(n < 3)
            return n;
        int[] stepsToReach = new int[n+1];

        stepsToReach[0] = 0;
        stepsToReach[1] = 1;
        stepsToReach[2] = 2;
        for(int i = 3; i < n+1; i++){
            stepsToReach[i] = stepsToReach[i-1] + stepsToReach[i-2];
        }
        return stepsToReach[n];
    }
}
