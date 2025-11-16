class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
        
        int n = nums1.length, m = nums2.length;
        int total = n + m;
        int target = (total + 1) >> 1;
        int l = 0, r = n;
        
        while (l <= r) {
            int p1 = (l + r) >> 1, p2 = target - p1;
            
            int l1 = safeGet(p1 - 1, nums1), r1 = safeGet(p1, nums1);
            int l2 = safeGet(p2 - 1, nums2), r2 = safeGet(p2, nums2);
            
            if (l1 > r2) r = p1 - 1;
            else if (l2 > r1) l = p1 + 1;
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
    
    private int safeGet(int idx, int[] nums) {
        if (idx < 0) return Integer.MIN_VALUE;
        if (idx >= nums.length) return Integer.MAX_VALUE;
        
        return nums[idx];
    }
    
}

/**
 *
 *  arr1: 1 2 3 4 6 8 11
 *  arr2: 5 7 9 10
 *
 *  [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] -> final sorted
 *
 *  l1 = 7, l2 = 4
 *  m = 11, target = 6
 *
 * l = 0, r = 4
 * p1 = 2, p2 = 4
 *            l2 r2
 * [1, 2, 3, 4] [6, 8, 11]
 *     l1  r1
 * [5, 7] [9, 10]
 * l1 > r2 invalid split go left
 *
 * l = 0, r = 1
 * p1 = 0, p2 = 6
 *              l2  r2
 * [1, 2, 3, 4, 6] [8, 11]
 *  l1  r1
 * [] [5, 7, 9, 10]
 * 6 > 5 invalid split go right
 *
 * l = 1, r = 1
 * p1 = 1, p2 = 5
 *              l2  r2
 * [1, 2, 3, 4, 6] [8, 11]
 *  l1  r1
 * [5] [7, 9, 10]
 *
 * l1 <= r2 && l2 <= r1 -> valid split
 *
 *if (odd) return Max(l1, l2)
 * else return (Max(l1, l2) + Min(r1, r2)) / 2.0
 *
 *
 */
