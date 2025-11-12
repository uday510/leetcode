class Solution {
    public int minOperations(int[] arr) {
        int n = arr.length, minOps = n + 1;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            cnt += arr[i] == 1 ? 1 : 0;
            for (int j = i + 1; j < n; j++) {
                cur = getEucliedianGCD(cur, arr[j]);
                if (cur == 1) {
                    minOps = Math.min(minOps, j - i + 1);
                    break;
                }
            }
        }

        if (cnt > 0) return n - cnt;

        if (minOps == n + 1) return -1;

        return n + minOps - 2;
    }

    private int getEucliedianGCD(int x, int y) {;
        while (y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;
    }
}