class Solution {
    public int[] searchRange(int[] arr, int t) {
        int p1 = bs(arr, t);

        if (p1 == arr.length || arr[p1] != t) return new int[] {-1, -1};

        int p2 = bs(arr, t + 1) - 1;

        return new int[] {p1, p2};
    }

    private int bs(int[] arr, int t) {

        int l = 0, r = arr.length;

        while (l < r) {
            int m = l + ((r - l) >> 1);

            if (arr[m] < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}