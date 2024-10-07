class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == 'B') {
                if (!st.isEmpty() && st.peek() == 'A') {
                    st.pop();
                } else {
                    st.push(c);
                }
            } else if (c == 'D') {
                if (!st.isEmpty() && st.peek() == 'C') {
                    st.pop();
                } else {
                    st.push(c);
                }
            } else {
                st.push(c);
            }
            System.out.println(st);
        }
        return st.size();
    }
}