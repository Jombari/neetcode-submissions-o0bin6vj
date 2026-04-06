class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(stack.size() != 0 && temperatures[stack.peek()] < temperatures[i]){
                int originalIndex = stack.pop();
                res[originalIndex] = i-originalIndex;
            }
            stack.add(i);
        }
        return res;
    }
}
