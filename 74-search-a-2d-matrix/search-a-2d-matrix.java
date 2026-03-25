class Solution {
    public boolean searchMatrix(int[][] arr, int t) {
        int n = arr.length, m = arr[0].length;
        int i = 0, j = m - 1;

        while (i < n && j < m && i > -1 && j > -1) {
            int cur = arr[i][j];

            if (cur == t) return true;

            if (cur < t) i++;
            else j--;
        }

        return false;
    }
}