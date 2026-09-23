class Solution {
    public int minOperations(int[] arr, int x) {
        int n = arr.length, total = Arrays.stream(arr).sum();
        int target = total - x;
        int cur = 0, mx = Integer.MIN_VALUE;

        for (int l = 0, r = 0; r < n; r++) {
            cur += arr[r];

            while (cur > target && l <= r) {
                cur -= arr[l++];
            }

            mx = cur != target ? mx : Math.max(mx, r - l + 1);
        }

        return mx == Integer.MIN_VALUE ? -1 : n - mx;
    }
}