class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, n = nums1.length, m = nums2.length;

        while (i < n && j < m) {
            
            if (nums1[i] < nums2[j]) {
                list.add(nums1[i++]);
            } else {
                list.add(nums2[j++]);
            }
        }

        while (i < n) {
        list.add(nums1[i++]);
        }

        while (j < m) {
            list.add(nums2[j++]);
        }

        int total = list.size();

        if (total % 2 == 0) {
            int t1 = list.get(total / 2);
            int t2 = list.get((total / 2) - 1);
            return (t1 + t2) / 2.0;
        }

        return list.get(total / 2);

    }
}