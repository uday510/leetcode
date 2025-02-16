class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) return;

        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                res.add(nums1[i]);
                i++;
            } else {
                res.add(nums2[j]);
                j++;
            }
        }

        while (i < m) {
            res.add(nums1[i]);
            i++;
        }

        while (j < n) {
            res.add(nums2[j]);
            j++;
        }

        for (int idx = 0; idx < res.size(); ++idx) {
            nums1[idx] = res.get(idx);
        }
    }
}

/***

1 2 3 0 0 0  ||  2 5 6 || [1 2 2 3]

i = 3 < 3
j = 1 < 3



 */