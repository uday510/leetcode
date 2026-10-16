class Solution {
    public int trap(int[] h) {
        int n = h.length, trapped = 0;
        int i = 0, j = n - 1;
        int lmx = 0, rmx = 0;

        while (i < j) {
            if (h[i] <= h[j]) {
                lmx = Math.max(lmx, h[i]);
                trapped += lmx - h[i++];
            } else {
                rmx = Math.max(rmx, h[j]);
                trapped += rmx - h[j--];
            }
        }
        
        return trapped;
    }
}