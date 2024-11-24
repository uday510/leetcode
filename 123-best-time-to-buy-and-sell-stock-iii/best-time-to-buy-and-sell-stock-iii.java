class Solution {
    public int maxProfit(int[] prices) {
        int buyOne = Integer.MAX_VALUE;
        int profitOne = 0;
        int buyTwo = Integer.MAX_VALUE;
        int profitTwo = 0;

        for (int price : prices) {
            buyOne = Math.min(buyOne, price);
            profitOne = Math.max(profitOne, price - buyOne);
            buyTwo = Math.min(buyTwo, price - profitOne);
            profitTwo = Math.max(profitTwo, price - buyTwo);
        }

        return profitTwo;
    }
}

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/solutions/39611/is-it-best-solution-with-o-n-o-1/?envType=study-plan-v2&envId=top-interview-150