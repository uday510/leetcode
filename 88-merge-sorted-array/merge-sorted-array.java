class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int m1 = m - 1, n1 = n - 1;
        int idx = nums1.length - 1;

        while (m1 > -1 && n1 > -1) {
            if (nums2[n1] > nums1[m1]) {
                nums1[idx--] = nums2[n1--];
            } else {
                nums1[idx--] = nums1[m1--];
            }
        }

        while (n1 > -1) {
            nums1[idx--] = nums2[n1--];
        }
        
    }
}