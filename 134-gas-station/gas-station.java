class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();

        if (gasSum < costSum) 
            return -1;
        
        int n = gas.length;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < n; ++i) {
            tank += gas[i] - cost[i];

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
}