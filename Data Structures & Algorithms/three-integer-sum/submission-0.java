class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            int target = nums[i] * -1;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int curSum = nums[left] + nums[right];
                if(target == curSum){
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    answer.add(tmpList);
                    left++;
                    while(left < right && nums[left] == nums[left-1]) left++;
                } else if( target > curSum){
                    left++;
                } else{
                    right--;
                }
            }
            i++;
            while(i<nums.length && nums[i] == nums[i-1]){
                i++;
            }
        }
        return answer;        
    }

}
