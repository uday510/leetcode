class Solution {
    public int calculate(String s) {
        int n = s.length();
        var stack = new Stack<Integer>();
        int currNum = 0;
        int operation = '+';

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = (currNum * 10) + (c - '0');
            }
            
            if (!Character.isDigit(c) && c != ' ' || i == n - 1) {

                if (operation == '+') {
                    stack.push(currNum);
                } else if (operation == '-') {
                    stack.push(-currNum);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currNum);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currNum);
                }

                operation = c;
                currNum = 0;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}