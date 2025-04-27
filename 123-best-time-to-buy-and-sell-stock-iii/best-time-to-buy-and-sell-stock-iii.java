class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = (int) 1e9;
        int profit1 = -(int) 1e9;
        int buy2 = (int) 1e9;
        int profit2 = -(int) 1e9;

        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);

            buy2 = Math.min(buy2, price - profit1);;
            profit2 = Math.max(profit2, price - buy2);
        }

        return profit2;
    }
}

/**


1, 2, 3, 4, 5

buy1 = 1 | profit1 = 1

buy2 = 1 | profit2 = 0


 */