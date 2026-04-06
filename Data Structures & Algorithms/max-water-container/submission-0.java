class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j= heights.length-1;
        int max = 0;
        
        while (i < j){
            max = Math.max(max, Math.min(heights[j],heights[i]) * Math.abs(i-j));
            if(heights[j] > heights[i]){
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
