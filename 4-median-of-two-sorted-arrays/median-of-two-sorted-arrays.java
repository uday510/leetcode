class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;

        List<Integer> list = new ArrayList<>();

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) list.add(nums1[i++]);
            else list.add(nums2[j++]);
        }

        while (i < n) list.add(nums1[i++]);

        while (j < m) list.add(nums2[j++]);

        int k = n + m;
        double res = -1;

        if ((k & 1) == 1) {
            res = (double) list.get(k / 2);
        } else {
            int a = list.get((k-1)/2);
            int b = list.get(k/2);
            res = (double) (a + b) / 2;
        }

        return res;
    }
}

/**

1 2 3 4


 */