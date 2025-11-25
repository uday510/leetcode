class Solution {
    public List<Integer> spiralOrder(int[][] A) {
        int N = A.length, M = A[0].length;
        int r1 = 0, r2 = N - 1;
        int c1 = 0, c2 = M - 1;

        List<Integer> res = new ArrayList<>();

        while (r1 <= r2 && c1 <= c2) {

            for (int c = c1; c <= c2; c++) {
                res.add(A[r1][c]);
            }

            for (int r = r1 + 1; r <= r2; r++) {
                res.add(A[r][c2]);
            }

            if (r1 == r2) break;
            for (int c = c2 - 1; c >= c1; c--) {
                res.add(A[r2][c]);
            }

            if (c1 == c2) break;

            for (int r = r2 - 1; r > r1; r--) {
                res.add(A[r][c1]);
            }

            r1++; r2--;
            c1++; c2--;
        }

        return res;
    }
}