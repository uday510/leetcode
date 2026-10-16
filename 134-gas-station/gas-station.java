class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int st = 0, left = 0, total = 0;

        for (int i = 0; i < n; i++) {
            int cur = gas[i] - cost[i];

            left += cur;
            total += cur;

            if (left < 0) {
                st = i + 1;
                left = 0;
            }
        }

        return total < 0 ? -1 : st;
    }
}