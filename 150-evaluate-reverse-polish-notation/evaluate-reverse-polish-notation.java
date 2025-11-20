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
            if (!hs.contains(token)) {
                st.push(Integer.parseInt(token));
            } else {

                int b = st.pop();
                int a = st.pop();
                char op = token.charAt(0);

                switch(op) {
                    case '+': st.push(a + b); break;
                    case '-': st.push(a - b); break;
                    case '*': st.push(a * b); break;
                    default: st.push(a / b); break;
                }
            }
        }

        return st.peek(); 
    }
}