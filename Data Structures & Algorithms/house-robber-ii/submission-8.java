class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(robHelper(0,nums.length-1,nums), robHelper(1,nums.length,nums));
    }

    public int robHelper(int left, int right, int[] nums){
        int rob1 = 0;
        int rob2 = 0;
        for(int i = left ; i < right; i++){
            int tmp = Math.max(rob1 + nums[i], rob2);
            rob1= rob2;
            rob2 = tmp;
        }
        return rob2;
    }
}
