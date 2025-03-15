class Solution {

    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int numRows;
    int numCols;

    public int numIslands(char[][] grid) {
        numRows = grid.length;
        numCols = grid[0].length;
        int numIslands = 0;

        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
               if (grid[row][col] != '1') continue;

                dfs(row, col, grid);
                numIslands++;
            }
        }

//  https://leetcode.com/discuss/post/6538154/amazon-onsite-question-sde-1-by-anonymou-hq8q/
        // for (int row = 0; row < numRows; ++row) {
        //     for (int col = 0; col < numCols; ++col) {

        //         if (grid[row][col] == '#' && canMerge(row, col, grid)) {
        //             numIslands--;
        //         }
        //     }
        // }

        return numIslands;
    }

    private void dfs(int row, int col, char[][] grid) {
         if (row < 0 || row >= numRows || col < 0 || col >= numCols 
            || grid[row][col] != '1') return;

        grid[row][col] = '#';

        for (int[] dir : dirs) {
            int R = dir[0] + row;
            int C = dir[1] + col;
            dfs(R, C, grid);
        }
    }

    private boolean canMerge(int row, int col, char[][] grid) {
        int islands = 0;

        for (int[] dir : dirs) {
            int R = row + dir[0];
            int C = col + dir[1];

            if (R < 0 || R >= numRows || C < 0 || C >= numCols || grid[R][C] != '#') 
                continue;
            
            islands++;
        }

        return islands >= 2;
    }
}