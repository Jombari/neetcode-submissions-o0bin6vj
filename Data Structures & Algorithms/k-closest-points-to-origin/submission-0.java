class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        if(k == points.length)
            return points;
        
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> Double.compare(Math.sqrt(Math.pow(a[0],2) + Math.pow(a[1],2)), Math.sqrt(Math.pow(b[0],2) + Math.pow(b[1],2))));
        for(int i = 0; i < points.length; i++){
            minHeap.offer(points[i]);
        }
        for(int i = 0; i < k ; i ++){
            res[i] = minHeap.poll();
        }
        return res;

    }
}