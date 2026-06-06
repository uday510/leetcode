class Solution {
    public int[] leftRightDifference(int[] arr) {
        int l = 0, r = 0, n = arr.length;

        for (int i = 0; i < n; i++) {
            r += arr[n - i - 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            l += arr[i];
            res[i] = Math.abs(r - l);
            r -= arr[i];
        }

        return res;

    }
}