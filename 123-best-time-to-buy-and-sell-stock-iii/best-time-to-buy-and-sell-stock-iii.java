class Solution {
    public int maxProfit(int[] prices) {
       int len = prices.length;
       int[] left = new int[len];
       int[] right = new int[len + 1];
       int leftMin = prices[0];
       int rightMax = prices[len - 1];

       for (int idx = 1; idx < len; ++idx) {
        leftMin = Math.min(leftMin, prices[idx]);
        left[idx] = Math.max(left[idx - 1], prices[idx] - leftMin);

        int r = len - idx;
        right[r] = Math.max(right[r + 1], rightMax - prices[r]);
        rightMax = Math.max(rightMax, prices[r]);
       }


       int maxProfit = 0;

       for (int idx = 0; idx < len; ++idx) {
            int currProfit = left[idx] + right[idx + 1];
            maxProfit = Math.max(maxProfit, currProfit);
       }

       return maxProfit; 
    }
}