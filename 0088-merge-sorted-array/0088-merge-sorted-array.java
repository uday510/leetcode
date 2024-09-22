class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int N1 = m - 1;
        int N2 = n - 1;
        int idx = nums1.length - 1;
        
        while (N1 > -1 && N2 > -1) {
            if (nums1[N1] > nums2[N2]) {
                nums1[idx--] = nums1[N1--];
            } else {
                nums1[idx--] = nums2[N2--];
            }
        }
        
        while (N2 > -1) {
            nums1[idx--] = nums2[N2--];
        }
    }
}