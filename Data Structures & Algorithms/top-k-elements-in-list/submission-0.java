class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();


        for(int num: nums){
            int tmpCount = freqMap.computeIfAbsent(num, z -> 0);
            freqMap.put(num,++tmpCount);
        }

        List<Integer>[] freqBucket = new List[nums.length +1];

        for(int value: freqMap.keySet()){
            int frequency = freqMap.get(value);
            if(freqBucket[frequency] == null)
                freqBucket[frequency] = new ArrayList<Integer>();
            freqBucket[frequency].add(value);
        }

        List<Integer> answer = new ArrayList<>();

        for(int i = freqBucket.length-1; i>0 && answer.size() < k ; i--){
            if(freqBucket[i] != null)
                answer.addAll(freqBucket[i]);
        }

        return answer.stream().mapToInt(i -> i).toArray();

        
    
    }
}
