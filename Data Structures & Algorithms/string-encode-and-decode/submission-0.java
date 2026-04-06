class Solution {

    public String encode(List<String> strs) {
          StringBuilder sb = new StringBuilder();
          for(String word : strs){
            sb.append(word.length() +"#" + word);
          }
          return sb.toString();
    }

    public List<String> decode(String str) {
        int right = 0;
        int left = 0;
        List<String> decodedString = new ArrayList<String>();
        while( right<str.length()){
            while(str.charAt(right) != '#'){
                right++;
            }
            int stringLength = Integer.parseInt(str.substring(left,right++));
            decodedString.add(str.substring(right, right+stringLength));
            right +=stringLength;
            left = right;
        }

        return decodedString;
    }
}
