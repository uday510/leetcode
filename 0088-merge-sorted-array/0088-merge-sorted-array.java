class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m-1;
        int idx2 = n-1;
        int index = nums1.length-1;
        
        while (idx1 > -1 && idx2 > -1) {
            if (nums1[idx1] > nums2[idx2]) {
                nums1[index--] = nums1[idx1--];
            } else {
                nums1[index--] = nums2[idx2--];
            }
        }
        
        while (idx2 > -1) {
            nums1[index--] = nums2[idx2--];
        }
    }
}