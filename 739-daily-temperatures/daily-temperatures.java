class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = temps.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int cur = temps[i];
            while (!st.isEmpty() && cur > temps[st.peek()]) {
                int j = st.pop();
                res[j] = i - j;
            }
            st.push(i);
        }

        return res;
    }
}