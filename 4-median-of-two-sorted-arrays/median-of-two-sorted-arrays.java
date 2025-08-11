class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) list.add(num);
        for (int num : nums2) list.add(num);

        Collections.sort(list);

        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 0) {
            int t1 = list.get((m + n - 1) /2);
            int t2 = list.get((m + n) /2);
            return (double) (t1 + t2) / 2;
        } else {
            return (double) list.get((m + n )/ 2);
        }
    }
}