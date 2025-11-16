class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total, tank, idx;
        total = tank = idx = 0;

        for (int i = 0; i < gas.length; i++) {
            int cur = gas[i] - cost[i];
            total += cur;
            tank += cur;

            if (tank < 0) {
                tank = 0;
                idx = i + 1;
            }
        }

        return total >= 0 ? idx : -1;
    }
}