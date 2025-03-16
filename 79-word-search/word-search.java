class Solution {
    private int rows;
    private int cols;
    private boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        initialize(board);
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (dfs(0, row, col, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int index, int row, int col, char[][] board, String word) {
        if (index >= word.length()) return true;

        if (!valid(index, row, col, board, word)) {
            return false;
        } 

        vis[row][col] = true;

        if (
            dfs(index + 1, row + 1, col, board, word) ||
            dfs(index + 1, row - 1, col, board, word) || 
            dfs(index + 1, row, col + 1, board, word) ||
            dfs(index + 1, row, col - 1, board, word) 
            ) return true;

        vis[row][col] = false;
        return false;
    }
    private boolean valid(int i, int r, int c, char[][] board, String word) {
        return !(r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != word.charAt(i) ||
            vis[r][c]);
    }

    private void initialize(char[][] board) {
        this.rows = board.length;
        this.cols = board[0].length;
        vis = new boolean[rows][cols];
    }
}