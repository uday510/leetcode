class Solution {
    public int[] searchRange(int[] arr, int target) {
        int l = bs(arr, target);
        if (l >= arr.length || arr[l] != target) return new int[] {-1, -1};

        return new int[] {l, bs(arr, target + 1) - 1};
    }
    private int bs(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = (l + r) >> 1;

            if (arr[m] < target) l = m + 1;
            else r = m;
        }

        return l;
    }
}