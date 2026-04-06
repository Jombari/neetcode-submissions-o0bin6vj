class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        int number = 0;
        for(int i = 0; i < s.length()-1; i++){
            char numeral = s.charAt(i);                     
            int value = romanMap.get(numeral);
            char nextNumeral = s.charAt(i+1);
            int nextValue = romanMap.get(nextNumeral);
            if(value < nextValue)
                number -= value;
            else
                number += value;
        }

        return number + romanMap.get(s.charAt(s.length()-1));
    }
}