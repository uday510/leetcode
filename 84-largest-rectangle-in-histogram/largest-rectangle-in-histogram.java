class Solution {

    int[] heights;
    int n;

    public int largestRectangleArea(int[] heights) {
        this.heights = heights;
        n = heights.length;

        int[] NSL = getNSL();
        int[] NSR = getNSR();

        int maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            int w = NSR[i] - NSL[i] - 1;
            int a = w * heights[i];

            maxArea = Math.max(maxArea, a);
        }

        return maxArea;
    }

    private int[] getNSL() {
        int[] NSL = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peekLast()] >= heights[i]) {
                st.pollLast();
            }

            NSL[i] = st.isEmpty() ? -1 : st.peekLast();

            st.offerLast(i);
        }

        return NSL;
    }

    private int[] getNSR() {
        int[] NSR = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i > -1; i--) {
            while (!st.isEmpty() && heights[st.peekLast()] >= heights[i]) {
                st.pollLast();
            }

            NSR[i] = st.isEmpty() ? n : st.peekLast();

            st.offerLast(i);
        }

        return NSR;
    }
}