class Solution {
    private static final int[][] directions = new int[][]
            {
                    {0, 1},  // right
                    {0, -1}, // left
                    {1, 0}, // down
                    {-1, 0} // up
            };
    public void solve(char[][] board) {
        int numRows = board.length;
        int numCols = board[0].length;

        int[][] visited = new int[numRows][numCols];

        // check for boundary rows
        for (int col = 0; col < numCols; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col, visited);
            }
            if (board[numRows - 1][col] == 'O') {
                dfs(board, numRows - 1, col, visited);
            }
        }

        // check for boundary cols
        for (int row = 0; row < numRows; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0, visited);
            }
            if (board[row][numCols - 1] == 'O') {
                dfs(board, row, numCols - 1, visited);
            }
        }

        // flip the remaining 'O' to 'X' and '1' to 'O'
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
                // if (visited[i][j] == 1) {
                //     board[i][j] = 'O';
                // }
            }
        }
    }
    public void dfs(char[][] board, int row, int col, int[][] visited) {
        visited[row][col] = 1;


        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

           if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length &&
                   board[newRow][newCol] == 'O' && visited[newRow][newCol] == 0) {
                dfs(board, newRow, newCol, visited);
           }
        }
    }
}