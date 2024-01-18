import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 1 way to reach position 1
        queue.offer(1); // 1 way to reach position 2

        for (int i = 3; i <= n; i++) {
            int current = queue.poll() + queue.peek();
            queue.offer(current);
        }

        return queue.poll() + queue.peek();
    }
}
