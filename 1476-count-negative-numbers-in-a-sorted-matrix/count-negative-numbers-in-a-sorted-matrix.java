class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int i = 0;
        int j = n - 1;
        int cnt = 0;

        while (i > -1 && i < m && j > -1 && j < n) {

            int curr = grid[i][j];

            if (curr < 0) {
                cnt += (m - i);
                System.out.println ( i + " : " + j);
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
        [4,3,2,    0]
        [3,2,1,   -1]
        [1,1,-1,  -2]
        [-1,-1,-2,-3]
    ]

 */