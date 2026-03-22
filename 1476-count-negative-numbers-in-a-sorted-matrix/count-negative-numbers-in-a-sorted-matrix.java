class Solution {
    public int countNegatives(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int i = 0, j = m - 1;
        int cnt = 0;

        while (i < n && j > -1) {
            if (arr[i][j] < 0) {
                cnt += (n - i);
                j--;
            } else {
                i++;
            }
        }

        return cnt;
    }
}

/**

[
    [4,3,2,-1],
    [3,2,1,-1],
    [1,1,-1,-2],
    [-1,-1,-2,-3]

]

 */