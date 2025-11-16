class Solution {
    public int maxProfit(int[] prices) {
        int mx = 0, mn = prices[0];

        for (int p : prices) {
            mn = Math.min(mn, p);
            mx = Math.max(mx, p - mn);
        }

        return mx;
    }
}