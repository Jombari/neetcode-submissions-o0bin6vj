class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(robHelper(nums,1,nums.length),robHelper(nums,0,nums.length-1));
    }

    public int robHelper(int[] nums, int start, int end){
        int rob1 = 0;
        int rob2 = 0;


        for(int i = start; i < end ; i++){
            int newRob = Math.max(rob1 + nums[i],rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;        
    }
}
