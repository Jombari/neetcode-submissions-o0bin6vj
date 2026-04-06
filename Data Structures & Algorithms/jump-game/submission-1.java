class Solution {
    public boolean canJump(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[nums.length-1] = true;

        for(int i = nums.length-2; i >= 0; i--){
            for(int j = 1; j<=nums[i]; j++){
                if(j+i < nums.length && canReach[j+i]){
                    canReach[i] = true;
                    break;
                }
            }
        }
        return canReach[0];
    }
}
