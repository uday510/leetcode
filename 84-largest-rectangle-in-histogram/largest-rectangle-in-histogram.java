class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] NSL = getNSL(heights);
        int[] NSR = getNSR(heights);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int w = NSR[i] - NSL[i] - 1;
            int a = w * heights[i];

            maxArea = Math.max(maxArea, a);
        }

        return maxArea;
    }

    private int[] getNSL(int[] H) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] NSL = new int[H.length];

        for (int i = 0; i < H.length; i++) {
            int h = H[i];

            while (!st.isEmpty() && H[st.peekLast()] >= h) {
                st.pollLast();
            }

            if (st.isEmpty()) NSL[i] = -1;
            else NSL[i] = st.peekLast();

            st.offerLast(i);
        }
        
        return NSL;
    }

    private int[] getNSR(int[] H) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] NSR = new int[H.length];

        for (int i = H.length - 1; i > -1; i--) {
            int h = H[i];
            
            while (!st.isEmpty() && H[st.peekLast()] >= h) {
                st.pollLast();
            }

            if (st.isEmpty()) NSR[i] = H.length;
            else NSR[i] = st.peekLast();

            st.offerLast(i);
        }

        return NSR;
    }
}