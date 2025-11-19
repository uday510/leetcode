class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;

        int INF = Integer.MAX_VALUE;

        int[] buy  = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, INF);

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i]  = Math.min(buy[i], price - sell[i - 1]);
                sell[i] = Math.max(sell[i], price - buy[i]);
            }
        }

        return sell[k];
    }
}