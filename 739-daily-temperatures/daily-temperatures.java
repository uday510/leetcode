class Solution {
    public int[] dailyTemperatures(int[] tmps) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = tmps.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int cur = tmps[i];

            while (!st.isEmpty() && cur > tmps[st.peek()]) {
                res[st.peek()] = i - st.pop();
            }

            st.push(i);
        }

        return res;
    }
}