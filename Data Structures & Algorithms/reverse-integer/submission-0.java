class Solution {
    public int reverse(int x) {
        int minimum = -1* ((int)Math.pow(2,31));
        int maximum = ((int)Math.pow(2,31)) -1;
        int ans = 0;
        int digit =  x%10;
        while( x!=0){
            if((ans > maximum/10 || (ans == Integer.MAX_VALUE / 10 && digit > 7)) || ans < minimum / 10 || (ans == minimum / 10 && digit < -8)) {
                return 0;
            }
            ans *= 10;
            ans += x%10;
            x /= 10;
        }
        return ans;
    }
}
