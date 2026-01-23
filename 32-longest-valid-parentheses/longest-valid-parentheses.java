class Solution {

    private char OPEN = '(';

    public int longestValidParentheses(String s) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        int longest = 0;

        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == OPEN) {
                stack.push(i);
            } else {
               stack.pop();
               if (stack.isEmpty()) {
                stack.push(i);
               } else {
                longest = Math.max(longest, i - stack.peek());
              }
            }

        }

        return longest;
    }

}

/**


0 1 2 3 4 5
) ( ) ( ) )

-1, 1


*/