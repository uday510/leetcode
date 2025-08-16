class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l = 1, r = maxSum;
        int res = -1;

        while (l <= r) {
            int m = l + ((r - l) >> 1);
            
            if (cnt(n, m, index) <= (long) maxSum) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    private long cnt(int n, int val, int i) {
        long left = 0;

        if (val <= i) {
            left = (long) (val - 1) * val / 2  + (i - (val - 1));
        } else {
            // First term = val-1
	        // Last term = val - i
	        // Number of terms = i
            // sum = (first + last) * terms / 2 → ((val-1) + (val-i)) * i / 2
            left = (long) ( (val - 1) + (val - i) ) * i / 2;
        }

        long middle = val;
        long right = n - i - 1;

        if (val <= right) {
            right = (long) (val - 1) * val / 2 + (right - (val - 1));
        } else {
            right = (long) ( (val - 1) + (val - right) ) * right / 2;
        }

        return (long)left + middle + right;
    }
}