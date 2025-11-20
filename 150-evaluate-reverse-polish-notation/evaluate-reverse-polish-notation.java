class Solution {
    private final static Set<String> hs = new HashSet<>();
    static {
        hs.add("+");
        hs.add("-");
        hs.add("*");
        hs.add("/");
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();

        for (String token : tokens) {
            if (st.isEmpty() || !hs.contains(token)) {
                st.push(Integer.parseInt(token));
            } else {

                int v2 = st.pop();
                int v1 = st.pop();

                if (token.equals("+")) {
                    st.push(v1 + v2);
                } else if (token.equals("*")) {
                    st.push(v1 * v2);
                } else if (token.equals("-")) {
                    st.push(v1 - v2);
                } else {
                    st.push(v1 / v2);
                }
            }
        }

        return st.peek(); 
    }
}