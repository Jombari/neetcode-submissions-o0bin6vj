class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numsAppeared = new HashSet<Integer>();

        for(int i : nums){
            if(numsAppeared.contains(i))
                return true;
            numsAppeared.add(i);
        }
        return false;
    }
}