class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0)
            return true;
        if(memo.containsKey(s))
            return memo.get(s);
        int i = 1;
        while(i <= s.length()){
            if(wordDict.contains(s.substring(0,i)) && wordBreak(s.substring(i,s.length()),wordDict)){
                memo.put(s, true);
                return true;
            }
            i++;
        }
        memo.put(s, false);
        return false;
    }
}
