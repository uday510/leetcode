class Solution {
    public long getDescentPeriods(int[] prices) {
        long total = 0;
        int prev = -1, cnt = 0;

        for (int cur : prices) {
            if (prev - 1 != cur) {
                cnt = 1;
            } else {
                cnt++;
            }

            total += cnt;
            prev = cur;
        }   

        return total;
    }
}