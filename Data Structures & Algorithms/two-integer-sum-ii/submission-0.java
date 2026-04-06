class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> tracker = new HashMap<>();

        for(int i = 0; i < numbers.length; i ++){
            if(tracker.containsKey(numbers[i])){
                return new int[]{tracker.get(numbers[i]) +1, i+1};
            } else {
                tracker.put(target - numbers[i], i );
            }
        }
        return new int[0];
    }
}
