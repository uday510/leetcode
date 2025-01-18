class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length - 1;
        int idx1 = m - 1;
        int idx2 = n - 1;

        while (idx1 > -1 && idx2 > -1) {
            if (nums2[idx2] >= nums1[idx1]) {
                nums1[idx--] = nums2[idx2--];
            } else {
                nums1[idx--] = nums1[idx1--];
            }
        }

        while (idx2 > -1) {
            nums1[idx--] = nums2[idx2--];
        }

        return;
    }
}
