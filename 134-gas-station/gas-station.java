class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = Arrays.stream(gas).sum();
        int reqGas = Arrays.stream(cost).sum();

        if (totalGas < reqGas) return -1;

        int curGas = 0, idx = 0;

        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];

            if (curGas < 0) {
                curGas = 0;
                idx = i + 1;
            }
        }

        return idx;
    }
}