class Solution {
    public int maxArea(int[] H) {
        
        int mx = 0, cur = 0, i = 0, j = H.length - 1;

        while (i < j) {
            cur = Math.min(H[i], H[j]) * (j - i);
            mx = Math.max(cur, mx);

            if (H[i] <= H[j]) i++;
            else j--;
        }
        
        return mx;
    }
}