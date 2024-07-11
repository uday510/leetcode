class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c != ')') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                
                for (char ch : sb.toString().toCharArray()) {
                    stack.push(ch);
                }
            }
        }
            
        StringBuilder sb = new StringBuilder();
            
        for (char c : stack) {
                sb.append(c);
        }
            
        return sb.toString();
    }
}