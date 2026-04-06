class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefixMap = new HashMap<Integer,Integer>();
        int ans = 0;
        int curSum = 0;
        prefixMap.put(0,1);
        for(int num : nums){
            curSum += num;
            ans += prefixMap.getOrDefault(curSum - k, 0);
            int count = prefixMap.getOrDefault(curSum,0);
            count++;
            prefixMap.put(curSum,count);
        }
        return ans;
    }

        
}