class Solution {
    public int largestRectangleArea(int[] H) {
        int n = H.length;
        int[] NSL = getNSL(H, n);
        int[] NSR = getNSR(H, n);
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int w = NSR[i] - NSL[i] - 1;
            int a = w * H[i];

            maxArea = Math.max(maxArea, a);
        }

        return maxArea;
    }

    private int[] getNSL(int[] H, int n) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] NSL = new int[n];
        NSL[0] = -1;

        for (int i = 0; i < n; i++) {
            
            while (!st.isEmpty() && H[st.peek()] >= H[i]) st.pop();

            if (st.isEmpty()) NSL[i] = -1;
            else NSL[i] = st.peek();

            st.push(i);
        }

        return NSL;
    }

    private int[] getNSR(int[] H, int n) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] NSR = new int[n];
        NSR[n - 1] = n;

        for (int i = n - 1; i > -1; i--) {
            while (!st.isEmpty() && H[st.peek()] >= H[i]) st.pop();

            if (st.isEmpty()) NSR[i] = n;
            else NSR[i] = st.peek();

            st.push(i);
        }

        return NSR;
    }
}