class Solution {
    public boolean searchMatrix(int[][] A, int target) {
        int N = A.length, M = A[0].length;
        int i = 0, j = M - 1;

        while (i < N && j < M && i > -1 && j > -1) {
            int cur = A[i][j];

            if (cur == target) return true;

            if (cur < target) i++;
            else j--;
        }

        return false;
    }
}