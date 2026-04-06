class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        for(int[] interval : intervals){
            pq.offer(interval);
        }

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            while(!pq.isEmpty() && pq.peek()[0] <= cur[1]){
                cur[1] = Math.max(cur[1],pq.poll()[1]);
            }
            res.add(cur);
        }

        return res.toArray(new int[0][]);        
    }
}
