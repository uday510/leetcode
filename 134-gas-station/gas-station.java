class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = Arrays.stream(gas).sum();
        int requiredGas = Arrays.stream(cost).sum();

        if (totalGas < requiredGas) return -1;

        int currGas = 0;
        int index = 0;

        for (int idx = 0; idx < gas.length; ++idx) {
            currGas += (gas[idx] - cost[idx]);

            if (currGas < 0) {
                currGas = 0;
                index = idx + 1;
            }
        }

        return index;
    }
}