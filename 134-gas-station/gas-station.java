class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, total = 0, startIdx = 0;

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if (tank < 0) {
                startIdx = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? startIdx : -1;
    }
}