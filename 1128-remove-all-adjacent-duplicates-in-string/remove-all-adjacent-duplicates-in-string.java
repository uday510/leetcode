class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (st.isEmpty()) {
                st.offerLast(ch);
            } else {
                if (st.peekLast() == ch) {
                    st.pollLast();
                } else {
                    st.offerLast(ch);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : st) sb.append(ch);

        return sb.toString();
    }
}