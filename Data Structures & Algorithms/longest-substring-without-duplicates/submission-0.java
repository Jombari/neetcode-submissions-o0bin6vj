class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character,Integer> charCnt = new HashMap<>();
        int start = 0; 
        if(s.length() == 0)
            return 0;
        for(int end = start; end < s.length(); end++){
            char nextChar = s.charAt(end);
            while(charCnt.getOrDefault(nextChar, 0) > 0){
                char startChar = s.charAt(start);
                charCnt.put(startChar, charCnt.get(startChar) - 1);
                start++;
            }
            charCnt.put(nextChar, 1);
            if(max < (end-start+1)){
                max = end-start+1;
            }
        }
        return max;
        
    }
}
