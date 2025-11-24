class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, total = 0, n = gas.length, st = 0;

        for (int i = 0; i < n; i++) {
            int cur = gas[i] - cost[i];

            total += cur;
            tank += cur;

            if (tank < 0) {
                tank = 0;
                st = i + 1;
            }
        }

        return total >= 0 ? st : -1;
    }
}