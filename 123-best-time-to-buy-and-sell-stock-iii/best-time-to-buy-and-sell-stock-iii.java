class Solution {
    public int maxProfit(int[] prices) {
        // buy transaction1
        int t1Cost = Integer.MAX_VALUE;
        // sell transaction1  
        int t1Profit = 0;
        // buy transaction2
        int t2Cost = Integer.MAX_VALUE;
        // sell transaction2
        int t2Profit = 0;

        for (int price : prices) {
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);

            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }

        return t2Profit;
    }
}