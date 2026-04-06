class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int[] curr = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(curr[1] < intervals[i][0]){
                res.add(curr);
                curr = intervals[i];
            } else{
                curr[1] = Math.max(intervals[i][1], curr[1]);
            }
        }
        res.add(curr);

        return res.toArray(new int[res.size()][]);


    }
}
