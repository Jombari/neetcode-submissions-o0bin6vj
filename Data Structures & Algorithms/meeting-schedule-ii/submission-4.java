/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;
        intervals.sort((a,b) -> a.start-b.start);
        Queue<Integer> q = new PriorityQueue<>();
        int max = 0;
        for(Interval interval : intervals){
            while(q.peek() != null && q.peek() <= interval.start){
                q.poll();
            }
            q.add(interval.end);
            max = Math.max(q.size(),max);
        }
        return max;
    }
}
