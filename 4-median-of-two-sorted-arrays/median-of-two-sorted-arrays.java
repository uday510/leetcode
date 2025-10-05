class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);

        int n = nums1.length, m = nums2.length;
        int total = m + n;
        int target = (total + 1) >> 1;

        int l = 0, r = n;

        while (l <= r) {
            int m1 = (l + r) >> 1, m2 = target - m1;
            
            int l1 = safeGet(m1 - 1, nums1), l2 = safeGet(m2 - 1, nums2);
            int r1 = safeGet(m1, nums1), r2 = safeGet(m2, nums2);

            if (l1 > r2) r = m1 - 1;
            else if (l2 > r1) l = m1 + 1;

            else if (l1 <= r2 && l2 <= r1) {
                double median = -1;

                if ((total & 1) == 1) {
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
        int val = -1;
        if (i < 0) val = Integer.MIN_VALUE;
        else if (i >= nums.length) val = Integer.MAX_VALUE;
        else val = nums[i];

        return val;  
    }
}