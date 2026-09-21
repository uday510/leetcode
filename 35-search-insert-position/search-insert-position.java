class Solution {
    public int searchInsert(int[] arr, int t) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = l + ((r - l) >> 1);

            if (arr[m] < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}