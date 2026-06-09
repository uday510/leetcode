class Solution {
    public long maxTotalValue(int[] arr, int k) {
        long mx = -(int) 1e9;
        long mn = -mx;

        for (int cur : arr) {
            mx = Math.max(mx, cur);
            mn = Math.min(mn, cur);
        }

        return (mx - mn) * k;
    }
}
