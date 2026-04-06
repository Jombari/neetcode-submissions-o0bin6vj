class Solution {
    public int majorityElement(int[] nums) {
        int halfSize = nums.length/2;
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int num : nums){
            int freq = freqMap.computeIfAbsent(num, z -> 0);
            if(freq + 1 > halfSize)
                return num;
            freqMap.put(num,freq+1);
        }
        return -1;
    }
}