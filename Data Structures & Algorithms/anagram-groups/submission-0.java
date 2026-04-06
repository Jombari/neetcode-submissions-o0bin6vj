class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> charsToAnagrams = new HashMap<>();

        for(String word : strs){
            char[] tmpArray = word.toCharArray();
            Arrays.sort(tmpArray); 
            String sortedWord = new String(tmpArray);
            List<String> anagramList = charsToAnagrams.getOrDefault(sortedWord, new ArrayList<>());
            anagramList.add(word);
            charsToAnagrams.put(sortedWord,anagramList);
        }

        List<List<String>> answer = new ArrayList<>(charsToAnagrams.values());

        return answer;

    }
}
