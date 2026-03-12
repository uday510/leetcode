class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, idx = 0, cur, n = gas.length;

        for (int i = 0; i < n; i++) {
            cur = gas[i] - cost[i];
            total += cur;
            tank += cur;

            if (tank < 0) {
                tank = 0;
                idx = i + 1;
            }
        }

        return total < 0 ? -1 : idx;
    }
}