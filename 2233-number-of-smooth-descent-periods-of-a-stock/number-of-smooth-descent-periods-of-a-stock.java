class Solution {
    public long getDescentPeriods(int[] prices) { 

        long total = 0;
        int i = 0, n = prices.length;
        int len;

        for (int j = 1; j < n; j++) {

            if (prices[j] != prices[j - 1] - 1) {
                len = j - i;
                total += (long) len * (len + 1) / 2;
                i = j;
            }

        }

        len = n - i;
        total += (long) len * (len + 1) / 2;

        return total;
    }
}