class Solution {
    public boolean isValid(String s) {
        Stack<Character> openTracker = new Stack<>();
        HashMap<Character,Character> openerSet = new HashMap<>();
        openerSet.put('[',']');
        openerSet.put('{','}');
        openerSet.put('(',')');

        for(char c : s.toCharArray()){
            if(openerSet.keySet().contains(c)){
                openTracker.add(c);
            } else if(openTracker.size() <= 0 || c != openerSet.get(openTracker.peek())){
                return false;
            } else {
                openTracker.pop();
            }
        }
        return openTracker.size() == 0;
    }
}
