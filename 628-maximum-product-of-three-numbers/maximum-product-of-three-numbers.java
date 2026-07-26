class Solution {
    public int maximumProduct(int[] arr) {
        
        int mx1, mx2, mx3;
        int mn1, mn2;

        mx1 = mx2 = mx3 = -(int) 1e9;
        mn1 = mn2 = -mx1;

        for (int a : arr) {
            
            if (a <= mn1) {
                mn2 = mn1;
                mn1 = a;
            } else if (a <= mn2) {
                mn2 = a;
            }

            if (a >= mx1) {
                mx3 = mx2;
                mx2 = mx1;
                mx1 = a;
            } else if (a >= mx2) {
                mx3 = mx2;
                mx2 = a;
            } else if (a >= mx3) {
                mx3 = a;
            }

        }

        return Math.max(mn1 * mn2 * mx1, mx1 * mx2 * mx3);
    }
}


/**


-2, -9, 2, 5, 6, ans = 90


 */