class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int max = 1;
        int tmpCnt =1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]-1 == nums[i-1] ){
                tmpCnt++;
            } else if(nums[i] != nums[i-1]){
                max = Math.max(max,tmpCnt);
                tmpCnt = 1;
            }
        }
        return Math.max(max,tmpCnt);
    }
}
