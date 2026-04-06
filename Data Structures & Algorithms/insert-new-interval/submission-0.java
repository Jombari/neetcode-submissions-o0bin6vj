class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tempAnswer = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && newInterval[0] > intervals[i][1] ){
            tempAnswer.add(intervals[i]);
            i++;
        }
        if(tempAnswer.size() == intervals.length){
            tempAnswer.add(newInterval);
            return tempAnswer.toArray(new int[0][]);
        }
        if(i<intervals.length && newInterval[0] > intervals[i][0] ){
            newInterval[0] = intervals[i][0];
        }
        while(i< intervals.length && newInterval[1] > intervals[i][1]){
            i++;
        }
        if(i < intervals.length && newInterval[1] >= intervals[i][0]){
            newInterval[1] = intervals[i][1];
            tempAnswer.add(newInterval);
            i++;
        } else {
            tempAnswer.add(newInterval);
        } 

        while(i < intervals.length){
            tempAnswer.add(intervals[i]);
            i++;

        }
        return tempAnswer.toArray(new int[0][]);
    }
}
