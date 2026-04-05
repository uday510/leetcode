class Solution {
    public int search(int[] arr, int t) {
        return bs(arr, t);
    }

    private int bs(int[] arr, int t) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (arr[m] < t) l = m + 1;
            else r = m;
        }

        return l == arr.length || arr[l] != t ? -1 : l;
    }
}