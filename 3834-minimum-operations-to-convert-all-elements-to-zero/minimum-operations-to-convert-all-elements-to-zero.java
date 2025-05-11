class Solution {
    public int minOperations(int[] nums) {
        int cnt = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
        if (stack.isEmpty() || stack.peek() < num) {
            stack.push(num);
            cnt++;
        }
    }
    return cnt;
    }
}
