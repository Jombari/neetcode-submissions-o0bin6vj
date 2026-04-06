class Solution {
    HashSet<Integer> history = new HashSet<>();

    public boolean isHappy(int n) {
        if(n==1)
            return true;
        if(history.contains(n))
            return false;
        history.add(n);
        int newN = 0;
        while(n>0){
            newN += Math.pow(n%10,2);
            n/=10;
        }
        return isHappy(newN);

        
    }
}
