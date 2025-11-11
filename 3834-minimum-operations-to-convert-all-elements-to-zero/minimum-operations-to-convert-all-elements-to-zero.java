class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            while (!st.isEmpty() && st.peek() > cur) st.pop();

            if (st.isEmpty() || cur > st.peek()) {
                cnt++;
                st.push(cur);
            }
        }

        return cnt;
    }
}