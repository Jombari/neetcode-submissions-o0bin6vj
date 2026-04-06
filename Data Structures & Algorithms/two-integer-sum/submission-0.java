class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> pairTracker = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            if(pairTracker.containsKey(num)){
                int j = pairTracker.get(num);
                return new int[]{j,i};
            }
            int remaining = target-num;
            pairTracker.put(remaining,i);
        }
        return null;
    }
}
