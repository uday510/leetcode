class Solution {

    public int search(int[] nums, int target) {
        return bs(nums, target);    
    }

    private int bs(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = (l + r) >> 1;

            if (arr[m] == target) return m;

            if (arr[m] < target) l = m + 1;
            else r = m;
        }

        return -1;
    }
}