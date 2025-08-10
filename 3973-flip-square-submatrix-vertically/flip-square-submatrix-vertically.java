class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        if (k == 1) return grid;
        
        int row = x;
        int lastRow = x + k - 1;

        while (row < lastRow) {

            int len = 0;
            for (int col = y; len < k; ++col) {
                int temp = grid[row][col];
                grid[row][col] = grid[lastRow][col];
                grid[lastRow][col] = temp;
                len++;
            }

            row++;
            lastRow--;
        }

        return grid;
    }
}

/**


[
x = 2, y = 1, k = 2



[
    [6,16,14]
    [1,2,19]
    [14,   17,15 ]
    [18,    7,6 ]
    [14,   12,15 ]
]

    [6,16,14]
    [1,2,19]
    [14,17,15]
    [18,7,6]
    [14,12,5]




    [
    [6,16,14]
    [1,2,19]
    [14,7,6]
    [18,17,15]
    [14,12,5]
    
    ]
]

**/