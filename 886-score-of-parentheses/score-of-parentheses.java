class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                st.push(st.pop() + Math.max(2 * v, 1));
            }
        }

        return st.peek();
    }
}