class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 == 1)
            return false;

        sum /=2;
        boolean[] tracker = new boolean[sum+1];
        tracker[0] = true;

        for(int num: nums){
            for(int i = sum ; i>= num; i--){
                tracker[i] = tracker[i] || tracker[i - num];
            }
        }
        return tracker[sum];
    }
}
