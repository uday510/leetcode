class Solution {

    private int n, m, cnt;
    private int[] r, c;
    private int[][] arr;

    public int numSpecial(int[][] arr) {
        this.arr = arr;
        n = arr.length;
        m = arr[0].length;
        r = new int[n];
        c = new int[m];

        compute(false);
        compute(true);

        return cnt;
    }
    
    private void compute(boolean add) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    if (!add) {
                        r[i]++;
                        c[j]++;
                    } else if (r[i] == 1 && c[j] == 1) {
                        cnt++;
                    }
                }
            }
        }

    }
}