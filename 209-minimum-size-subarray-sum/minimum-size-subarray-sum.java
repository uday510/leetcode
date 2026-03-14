class Solution {
    public int minSubArrayLen(int T, int[] A) {
        int n = A.length;
        int res = n + 1, cur = 0;

        for (int i = 0, j = 0; j < n; j++) {
            cur += A[j];

            while (i <= j && cur >= T) {
                res = Math.min(res, j - i + 1);
                cur -= A[i++];
            }

        }

        return res == n + 1 ? 0 : res;

    }
}