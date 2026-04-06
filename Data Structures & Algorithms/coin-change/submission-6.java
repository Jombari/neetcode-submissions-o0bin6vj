public class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = 0;
        if(amount == 0)
            return res;
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] seen = new boolean[amount+1];
        seen[0] = true;
        q.add(0);
        
        while(!q.isEmpty()){
            int size = q.size();
            res++;
            for(int i = 0; i <size; i++){
                int curTotal = q.poll();
                for(int coin: coins){
                    if(curTotal + coin == amount)
                        return res;
                    if(coin + curTotal > amount || seen[curTotal+coin])
                        continue;
                    seen[curTotal+coin] = true;
                    q.add(curTotal + coin);
                }
            }
        }


        return -1;
    }
}