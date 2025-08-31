class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length, r1 = 0, c1 = 0, r2 = n - 1, c2 = m - 1;

        List<Integer> res = new ArrayList<>();

        while (r1 <= r2 && c1 <= c2) {

            for (int c = c1; c <= c2; c++) res.add(mat[r1][c]);

            for (int r = r1 + 1; r <= r2; r++) res.add(mat[r][c2]);

            if (r1 == r2) break;

            for (int c = c2 - 1; c >= c1; c--) res.add(mat[r2][c]);

            if (c1 == c2) break;
            for (int r = r2 - 1; r > r1; r--) res.add(mat[r][c1]);

            r1++;
            c1++;
            r2--;
            c2--;
        }

        return res;
    }
}