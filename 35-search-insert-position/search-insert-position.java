class Solution {
    public int searchInsert(int[] nums, int target) {
        return bs(nums, target);
    }
    private int bs(int[] arr, int t) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (arr[m] < t) l = m + 1;
            else r = m;
        }
        
        return l;
    }
}