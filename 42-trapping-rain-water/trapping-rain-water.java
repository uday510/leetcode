class Solution {
    public int trap(int[] H) {
        int l = 0, r = H.length - 1;
        int lMax = 0, rMax = 0;
        
        int water = 0;

        while (l < r) {

            if (H[l] <= H[r]) {
                lMax = Math.max(H[l], lMax);
                water += lMax - H[l++];
            } else {
                rMax = Math.max(H[r], rMax);
                water += rMax - H[r--];
            }

        }

        return water;
    }
}

/**


4  2  0  3  2  5 

l  =  5
r  =  5

lMax = 4
rMax = 0

water = 0 + 0 + 2 + 4 + 1 + 2 = 9


 */