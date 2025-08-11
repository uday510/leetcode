class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int total = n1 + n2;
        int target = (total + 1) / 2;

        int l = 0;
        int r = n1;

        while (l <= r) {
            int m1 = (l + r) >> 1;
            int m2 = target - m1;

            int mx1 = safeGet(nums1, m1 - 1);
            int mn1 = safeGet(nums1, m1);
            int mx2 = safeGet(nums2, m2 - 1);
            int mn2 = safeGet(nums2, m2);

            if (mx1 > mn2) {
                r = m1 - 1;
                continue;
            }
            if (mx2 > mn1) {
                l = m1 + 1;
                continue;
            }

            int medianValOdd = Math.max(mx1, mx2);
            if (total % 2 == 1) return medianValOdd;
            return (medianValOdd + Math.min(mn1, mn2)) / 2.0;
        }

        return -1;
    }

    private int safeGet(int[] nums, int idx) {
        if (idx < 0) return Integer.MIN_VALUE;
        if (idx >= nums.length) return Integer.MAX_VALUE;
        return nums[idx];
    }
}

/**

1. apply bs on smaller array

---------------------------------
1  2  3  4  6  8  11
0  1  2  3  4  5  6  


5  7  9  10
0  1  2  3

----------------------------------
1  2  3  4  5  6  7  8  9  10  11
0  1  2  3  4  5  6  7  8   9  10 


 */