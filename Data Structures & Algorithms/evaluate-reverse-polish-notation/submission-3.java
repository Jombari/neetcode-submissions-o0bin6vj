class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0)
            return 0;
        HashSet<String> operands = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        operands.addAll(Arrays.asList("+","-","*","/"));
        for(int i = 0; i<tokens.length; i++){
            if(operands.contains(tokens[i])){
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(tokens[i].equals("+"))
                    num1+=num2;
                else if(tokens[i].equals("-"))
                    num1 -= num2;
                else if(tokens[i].equals("*"))
                    num1 *= num2;
                else if(tokens[i].equals("/"))
                    num1 /= num2;
                stack.push(num1);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
