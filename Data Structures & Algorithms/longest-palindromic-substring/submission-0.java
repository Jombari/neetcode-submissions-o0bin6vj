class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String palindrome = "";

        for(int i = 0; i < s.length(); i++){
            int palindromeLengthOdd = expandAroundCenter(s,i,i);
            int palindromeLengthEven = expandAroundCenter(s,i,i+1);

            if(palindromeLengthOdd > max && palindromeLengthOdd > palindromeLengthEven){
                max = palindromeLengthOdd;
                int startingIndex = i - palindromeLengthOdd/2;
                palindrome = s.substring(startingIndex,startingIndex+palindromeLengthOdd);
            }else if(palindromeLengthEven > max && palindromeLengthEven > palindromeLengthOdd){
                max = palindromeLengthEven;
                int startingIndex = i-(palindromeLengthEven/2 - 1);
                palindrome = s.substring(startingIndex,startingIndex + palindromeLengthEven);
            }
        }
        return palindrome;
        
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Returns the length of the palindrome found
        return right - left - 1;
}
}
