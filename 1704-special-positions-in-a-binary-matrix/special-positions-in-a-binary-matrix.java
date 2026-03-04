class Solution {

    public int numSpecial(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[] r = new int[n];
        int[] c = new int[m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (arr[i][j] == 1) {
                    r[i]++;
                    c[j]++;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (arr[i][j] == 1 && r[i] == 1 && c[j] == 1) {
                    cnt++;
                }
             }
        }

        return cnt;
    }
}