class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1, m1 = m - 1, n1 = n - 1;

        while (m1 > -1 && n1 > -1) {
            if (nums1[m1] > nums2[n1]) {
                nums1[k--] = nums1[m1--];
            } else {
                nums1[k--] = nums2[n1--];
            }
        }

        while (m1 > -1) nums1[k--] = nums1[m1--];

        while (n1 > -1) nums1[k--] = nums2[n1--];
    }
}