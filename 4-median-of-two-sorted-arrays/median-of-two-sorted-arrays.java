class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length, m = nums2.length;
        int target = (n + m + 1) >> 1;

        int l = 0, r = n;

        while (l <= r) {
            int p1 = (l + r) >> 1, p2 = target - p1;

            int l1 = safeGet(p1 - 1, nums1), r1 = safeGet(p1, nums1); // nums1
            int l2 = safeGet(p2 - 1, nums2), r2 = safeGet(p2, nums2); // nums2

            if (l1 > r2) r = p1 - 1;
            if (l2 > r1) l = p1 + 1;
            else if (l1 <= r2 && l2 <= r1) {
                double median = -1;
                if (((m + n) & 1) == 1) {
                    median = Math.max(l1, l2);
                } else {
                    median = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
                return median;
            }
        }
        return -1;
    }

    private int safeGet(int i, int[] nums) {
        if (i < 0) return Integer.MIN_VALUE;
        if (i >= nums.length) return Integer.MAX_VALUE;
        return nums[i];
    }
}
