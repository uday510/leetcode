class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] l = new int[n];
        int[] r = new int[n + 1];

        int lMin = prices[0], rMax = prices[n - 1];

        for (int i = 1; i < n; i++) {
            lMin = Math.min(prices[i], lMin);
            l[i] = Math.max(l[i - 1], prices[i] - lMin);

            int rIdx = n - i - 1;
            rMax = Math.max(rMax, prices[rIdx]);
            r[rIdx] = Math.max(r[rIdx + 1], rMax - prices[rIdx]);
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, l[i] + r[i + 1]);
        }

        return max;
    }
}