class Solution {

    public int longestValidParentheses(String s) {
        

        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        int longest = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    longest = Math.max(longest, i - st.peek());
                }
            }
        }

        return longest;
    }
}


/**







 */