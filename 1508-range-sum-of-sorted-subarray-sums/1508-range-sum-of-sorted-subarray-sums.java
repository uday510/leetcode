import java.util.*;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i, i + 1});
        }
        
        int MOD = (int) 1e9 + 7;
        int sum = 0;

        for (int i = 1; i <= right; i++) {
            int[] current = pq.poll();
            if (i >= left) {
                sum = (sum + current[0]) % MOD;
            }
            if (current[2] < n) {
                pq.offer(new int[]{current[0] + nums[current[2]], current[1], current[2] + 1});
            }
        }
        
        return sum;
    }
}