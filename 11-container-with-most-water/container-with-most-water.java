class Solution {
    public int maxArea(int[] h) {
        int mx = 0, cur = 0;

        int i = 0, j = h.length - 1;
        while (i < j) {
            cur = Math.min(h[i], h[j]) * (j - i);
            mx = Math.max(mx, cur);

            if (h[i] <= h[j]) i++;
            else j--;
        }

        return mx;
    }
}