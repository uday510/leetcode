class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) return heights[0];
        int ans = Integer.MIN_VALUE;
        int[] NSL = NSL(heights);
        int[] NSR = NSR(heights);
        for (int i = 0; i < heights.length; i++) {
            ans = Integer.max(ans, heights[i] *
                    (NSR[i] - NSL[i] - 1));
        }
        return ans;
    }
    public int[] NSL(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currNum = array[i];

            if (stack.isEmpty()) {
                stack.push(i);
                ans[i] = -1;
            }
            else if (array[stack.peek()] < currNum) {
                ans[i] = stack.peek();
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && currNum <= array[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek();
                } else {
                    ans[i] = -1;
                }
                stack.push(i);
            }

        }
        return ans;
    }
    public int[] NSR(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i > -1; i--) {
            int currNum = array[i];

            if (stack.isEmpty()) {
                stack.push(i);
                ans[i] = array.length;
            }
            else if (array[stack.peek()] < currNum) {
                ans[i] = stack.peek();
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && currNum <= array[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek();
                } else {
                    ans[i] = array.length;
                }
                stack.push(i);
            }

        }
        return ans;
    }
}