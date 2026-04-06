class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        int[] case1 = new int[nums.length];
        int[] case2 = new int[nums.length];

        case1[0] = nums[0];
        case2[0] = nums[1];
        case1[1] = Math.max(nums[1], case1[0]);
        case2[1] = Math.max(nums[2], case2[0]);
        for(int i = 2; i < nums.length-1; i++){
            case1[i] = Math.max(nums[i] + case1[i-2], case1[i-1]);
            case2[i] = Math.max(nums[i+1] + case2[i-2], case2[i-1]);
        }
        return Math.max(case1[nums.length-2],case2[nums.length-2]);
    }
}
