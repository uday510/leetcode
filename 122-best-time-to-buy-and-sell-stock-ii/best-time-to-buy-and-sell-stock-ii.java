class Solution {
    public int maxProfit(int[] p) {
        int profit = 0;

        for (int i = 1; i < p.length; ++i) {
            profit += Math.max(p[i] - p[i - 1], 0);
        }

        return profit;
    }
}