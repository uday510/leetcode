class Solution {
    int n;
    int[] h;
    public int largestRectangleArea(int[] heights) {
        h = heights;
        n = h.length;

        int[] NSL = getNSL();
        int[] NSR = getNSR();

        int area = 0;

        for (int i = 0; i < n; i++) {
            int w = NSR[i] - NSL[i] - 1;
            int a = w * h[i];

            area = Math.max(area, a);
        }

        return area;
    }

    private int[] getNSL() {
        int[] NSL = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && h[st.peek()] >= h[i]) st.pop();

            NSL[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return NSL;
    }

    private int[] getNSR() {
        int[] NSR = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i > -1; i--) {
            
            while (!st.isEmpty() && h[st.peek()] >= h[i]) st.pop();

            NSR[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return NSR;
    }
}