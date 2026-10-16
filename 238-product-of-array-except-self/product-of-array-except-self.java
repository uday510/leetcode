class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] p = new int[n];

        int cur = 1;
        for (int i = 0; i < n; i++) {
            p[i] = cur;
            cur *= arr[i];
        }

        cur = 1;
        for (int i = n - 1; i > -1; i--) {
            p[i] *= cur;
            cur *= arr[i];
        }

        return p;
    }
}