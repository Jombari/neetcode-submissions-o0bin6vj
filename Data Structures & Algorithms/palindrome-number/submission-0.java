class Solution {
    public boolean isPalindrome(int x) {
        int tmpX = x;
        int newX = 0;
        if(x <0 )
            return false;
        while(tmpX > 0){
            newX*=10;
            newX+=tmpX%10;
            tmpX/=10;
        }
        if(newX == x)
            return true;
        return false;
    }
}