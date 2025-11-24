class Solution {
    public int trap(int[] H) {
        int l = 0, r = H.length - 1;
        int water = 0, lMax = 0, rMax = 0;

        while (l < r) {

            if (H[l] <= H[r]) {
                lMax = Math.max(lMax, H[l]);
                water += lMax - H[l++];
            } else {
                rMax = Math.max(rMax, H[r]);
                water += rMax - H[r--];
            }
        }

        return water;
    }
}