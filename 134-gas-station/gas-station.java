class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();

        if (totalGas < totalCost) return -1;

        int currentGas = 0;
        int gasStation = 0;

        for (int idx = 0; idx < gas.length; ++idx) {
            currentGas += (gas[idx] - cost[idx]);

            if (currentGas < 0) {
                gasStation = idx + 1;
                currentGas = 0;
            }
        }


        return currentGas > -1 ? gasStation : -1;
    }
}