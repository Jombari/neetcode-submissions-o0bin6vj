class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] characterCount = new int[26];

        for(char c : s.toCharArray()){
            characterCount[c-'a']++;
        }
        for(char c : t.toCharArray()){
            if(--characterCount[c-'a'] < 0)
                return false;
        }
        return true;

    }
}
