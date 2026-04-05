class Solution {
    public int search(int[] arr, int t) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = l + ((r - l) >> 1);

            int cur = arr[m];

            if (cur == t) return m;

            if (arr[l] <= arr[m]) {
                if (t >= arr[l] && t < arr[m]) r = m - 1;
                else l = m + 1;
            } else {
                if (t > arr[m] && t <= arr[r]) l = m + 1;
                else r = m - 1;
            }       
        }

        return -1;

    }
}
