class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()> s2.length()){
            return false;
        }

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(int i = 0; i< s2.length(); i++){
            if(i < s1.length()){
                s1Freq[s1.charAt(i) - 'a']++;
                s2Freq[s2.charAt(i) - 'a']++;
            } else {
                int matches = 0;
                for(int j = 0;j <26; j++){
                    if(s1Freq[j] ==s2Freq[j])
                        matches++;
                }
                if(matches == 26)
                    return true;
                s2Freq[s2.charAt(i-s1.length()) - 'a']--;
                s2Freq[s2.charAt(i) - 'a']++;

            }
        }
        int matches = 0;
        for(int j = 0;j <26; j++){
            if(s1Freq[j] ==s2Freq[j])
                matches++;
        }
        if(matches == 26)
            return true;
        return false;
    }
}
