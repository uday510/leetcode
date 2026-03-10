class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = nums1.length - 1;

        while (i > -1 && j > -1) {
            if (nums2[j] > nums1[i]) {
                nums1[index--] = nums2[j--];
            } else {
                nums1[index--] = nums1[i--];
            }
        }

        while (j > -1) {
           nums1[index--] = nums2[j--];
        }


    }
}