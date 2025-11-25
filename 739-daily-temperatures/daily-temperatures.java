class Solution {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = T.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int cur = T[i];

            while (!st.isEmpty() && cur > T[st.peek()]) {
                res[st.peek()] = i - st.pop();
            }

            st.push(i);
        }


        return res;
    }
}