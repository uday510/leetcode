class Solution {

    private int[] gas, cost;
    private int n;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        this.gas = gas;
        this.cost = cost;
        this.n = gas.length;

        int total = 0, tank = 0, st = 0, cur = 0;
        
        for (int i = 0; i < n; i++) {
//            if (canComplete(i)) {
//                return i;
//            }
            cur = gas[i] - cost[i];
            total += cur;
            tank += cur;

            if (tank < 0) {
                tank = 0;
                st = i + 1;
            }
        }
        
        return total < 0 ? -1 : st;
    }

    private boolean canComplete(int st) {

        int cur = 0;
        for (int i = 0; i < n; i++) {
            int idx = (i + st) % n;
            cur += gas[idx] - cost[idx];

            if (cur < 0) return false;
        }

        return true;
    }
}