class Solution {
    public int countNegatives(int[][] grid) {
        int col = grid[0].length - 1;
        int row = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        while (row < rows && col < cols && col > -1 && row > -1) {
            int val = grid[row][col];
            
            if (val < 0) {
                count += (rows - row);
                col--;
            } else {
                row++;
            }
        }

        return count;
    }
}

/**

[4,3,2,-1]
[3,2,1,-1]
[1,1,-1,-2]
[-1,-1,-2,-3]

 */