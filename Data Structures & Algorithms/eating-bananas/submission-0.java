class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        
        for(int i = 0; i < piles.length; i++){
            right = Math.max(right,piles[i]);
        }

        int min = right;
        while(left<= right){
            int mid = left + (right-left)/2;
            if(canEatBananasInTime(mid,h,piles)){
                min = Math.min(min,mid);
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return min;
    }

    private boolean canEatBananasInTime(int rate, int h,int[] piles){
        int hours = 0;
        for(int i= 0; i < piles.length; i++){
            hours+=piles[i]/rate;
            hours = piles[i] %rate == 0? hours : hours+1;
            if(hours>h)
                return false;
        }
        return true;
    }
}
