class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(0, nums.length - 1, nums);
        return nums;
    }

    private void mergesort(int l, int r, int[] nums) {
        if (l >= r) return;

        int m = (l + r) >> 1;

        mergesort(l, m, nums);
        mergesort(m + 1, r, nums);
        merge(l, m, m + 1, r, nums);
    }

    private void merge(int ls, int le, int rs, int re, int[] nums) {
        int[] l = new int[le - ls + 1];
        int[] r = new int[re - rs + 1];

        int n = l.length, m = r.length;
        for (int i = 0; i < n; i++) l[i] = nums[i + ls];

        for (int i = 0; i < m; i++) r[i] = nums[i + rs];
        
        int i = 0, j = 0, k = ls;
        
        while (i < n && j < m) {
            if (l[i] < r[j]) nums[k] = l[i++];
            else nums[k] = r[j++];
            k++;
        }
        
        while (i < n) nums[k++] = l[i++];
        while (j < m) nums[k++] = r[j++];
    }
}