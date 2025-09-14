class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) 
            return findMedianSortedArrays(nums2, nums1);

        int n = nums1.length, m = nums2.length;
        int total = n + m;
        int target = (total + 1) >> 1;

        int l = 0, r = n;

        while (l <= r) {
            int m1 = (l + r) >> 1;
            int m2 = target - m1;

            int l1 = safeGet(m1 - 1, nums1), l2 = safeGet(m2 - 1, nums2);
            int r1 = safeGet(m1, nums1), r2 = safeGet(m2, nums2);

            if (l1 <= r2 && l2 <= r1) {
                if ((total & 1 )== 1) return Math.max(l1, l2);

                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }

            if (l1 > r2) r = m1 - 1;
            if (l2 > r1) l = m1 + 1;
        }


        return -1;
    }

    private int safeGet(int i, int[] nums) {
        if (i >= nums.length) return Integer.MAX_VALUE;
        if (i <= -1) return Integer.MIN_VALUE;

        return nums[i];
    }
}