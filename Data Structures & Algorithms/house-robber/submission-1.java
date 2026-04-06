class Solution {
    private Integer[] memo;

    public int rob(int[] nums) {
        memo = new Integer[nums.length];
        return robHelper(nums, 0);
    }

    public int robHelper(int[] nums, int i){
        if(i>= nums.length)
            return 0;
        if(memo[i] != null)
            return memo[i];
        return memo[i] = Math.max(nums[i] + robHelper(nums, i + 2), robHelper(nums, i + 1));
    }
}
