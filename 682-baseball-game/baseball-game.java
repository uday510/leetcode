class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = ops.length;

        for (int i = 0; i < n; i++) {
            String s = ops[i];

            if (s.equals("+")) {
                if (st.size() > 1) {
                    int p1 = st.pop();
                    int p = p1 + st.peek();

                    st.push(p1);
                    st.push(p);
                }
            } else if (s.equals("D")) {
                if (!st.isEmpty()) {
                    st.push(2 * st.peek());
                }
            } else if (s.equals("C")) {
                if (!st.isEmpty()) st.pop();
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        int sum = 0;

        for (int val : st) sum += val;
       
        return sum;
    }
}