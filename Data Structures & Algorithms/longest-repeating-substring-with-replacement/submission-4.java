class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0)
            return 0;
        int maxLen = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int start = 0;
            int currentK = k;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != c) {
                    currentK--;
                }
                while (currentK < 0) {
                    if (s.charAt(start) != c) {
                        currentK++;
                    }
                    start++;
                }
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }
        return maxLen;
    }
}
