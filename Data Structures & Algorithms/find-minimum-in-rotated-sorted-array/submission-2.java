class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        if(nums[0] < nums[nums.length-1] || nums.length == 1){
            return nums[0];
        }
        while(left<= right){
            int mid = left+(right-left+1)/2;
            if(nums[mid]<nums[mid-1])
                return nums[mid];
            if(nums[right] >= nums[mid]){
                right = mid-1;
            } else {
                left = mid +1;
            }
        }
        return -1;
    }
}
