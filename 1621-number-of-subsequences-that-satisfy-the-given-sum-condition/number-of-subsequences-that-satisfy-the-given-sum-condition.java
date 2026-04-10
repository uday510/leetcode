class Solution {
    public int numSubseq(int[] arr, int t) {
        Arrays.sort(arr);

        int n = arr.length;
        int[] pow = new int[n];

        int mod = (int) 1e9 + 7;

        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        int cnt = 0;
        int l = 0, r = n - 1;

        while (l <= r) {

            if (arr[l] + arr[r] <= t) {
                cnt = (cnt + pow[r - l] % mod) % mod;
                l++;
            } else {
                r--;
            }
        }

        return cnt;
    }
}