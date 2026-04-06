class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        for(int i = 0; i < position.length; i++){
            maxHeap.offer(new int[]{position[i],speed[i]});
        }
        double minTime = -1;
        int count = 0;
        while(maxHeap.size() > 0){
            int[] car = maxHeap.poll();
            double tempTime = (double)(target - car[0]) / car[1];
            if(tempTime > minTime ){
                count++;
                minTime = tempTime;
            }
        }
        return count;
    }
}