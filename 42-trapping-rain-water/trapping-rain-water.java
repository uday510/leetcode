class Solution {
    public int trap(int[] H) {
        
        int n = H.length, trapped = 0;
        int i = 0, j = n - 1;
        int lMax = 0, rMax = 0;

        while (i < j) {
            if (H[i] <= H[j]) {
                lMax = Math.max(lMax, H[i]);
                trapped += lMax - H[i++];
            } else {
                rMax = Math.max(rMax, H[j]);
                trapped += rMax - H[j--];
            }   
        }

        return trapped;
    }
}