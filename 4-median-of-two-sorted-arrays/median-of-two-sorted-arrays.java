class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // Always binary search the smaller array
        // code works even without below line, but search space is more
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int total = n1 + n2;
        int target = (total + 1) / 2;

        int l = 0;
        int r = n1;

        while (l <= r) {
            int m1 = (l + r) >> 1;
            int m2 = target - m1;

            int left1 = safeGet(nums1, m1 - 1); // 7
            int right1 = safeGet(nums1, m1); // 9
            int left2 = safeGet(nums2, m2 - 1); //
            int right2 = safeGet(nums2, m2);

           
            if (left1 <= right2 && left2 <= right1) {
                // left1 <= right1 && left2 <= right2
                int medianValOdd = Math.max(left1, left2);
                if (total % 2 == 1) return medianValOdd;
                return (medianValOdd + Math.min(right1, right2)) / 2.0;
            } 
            else if (left1 > right2) r = m1 - 1;
            else if (left2 > right1) l = m1 + 1;
        }

        return -1;
    }

    private int safeGet(int[] nums, int idx) {
        if (idx < 0) return Integer.MIN_VALUE;
        if (idx >= nums.length) return Integer.MAX_VALUE;
        return nums[idx];
    }
}