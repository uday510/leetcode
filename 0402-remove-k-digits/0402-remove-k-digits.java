class Solution {
    public String removeKdigits(String num, int k) {        
        Stack<Character> stack = new Stack<>();

        for (char c : num.toCharArray()) {
           while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
               stack.pop();
               --k;
           }
           if (!stack.isEmpty() || c != '0')
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty() && k > 0){
            --k;
            stack.pop();
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        sb.reverse();
        
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}

 