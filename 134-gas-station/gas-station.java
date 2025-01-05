class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();

        if (totalGas < totalCost) {
            return -1;
        }

        int currentGas = 0;
        int startingStation = 0;

        for (int idx = 0; idx < gas.length; ++idx) {
            currentGas += gas[idx] - cost[idx];

            if (currentGas < 0) {
                currentGas = 0;
                startingStation = idx + 1;
            }
        }

        return currentGas < 0 ? -1: startingStation;
    }
}