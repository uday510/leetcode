class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m-1;
        int n2 = n-1;
        int idx = nums1.length-1;
        
        while (n1 > -1 && n2 > -1) {
            if (nums2[n2] >= nums1[n1]) {
                nums1[idx--] = nums2[n2--];
            } else {
                nums1[idx--] = nums1[n1--];
            }
        }
        
        while (n2 > -1) {
            nums1[idx--] = nums2[n2--];
        }
    }
}