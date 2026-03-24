class Solution {

    private static final int MOD = 12345;

    public int[][] constructProductMatrix(int[][] arr) {
        int r = arr.length, c = arr[0].length;
        int[][] res = new int[r][c];

        long cur = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = (int) cur;
                cur = (cur * arr[i][j]) % MOD;
            }
        }

        cur = 1;
        for (int i = r - 1; i > -1; i--) {
            for (int j = c - 1; j > -1; j--) {
                res[i][j] = (int) ((long) res[i][j] * cur ) % MOD;
                cur = (cur * arr[i][j]) % MOD;
            }
        }

        return res;
    }
}

/**

cur = 1

1 2
3 4

1 1
2 6


*/