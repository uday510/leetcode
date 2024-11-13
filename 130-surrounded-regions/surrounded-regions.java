class Solution {
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    int n;
    int m;
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;

        for (int j = 0; j < m; ++j) {
            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }

            if (board[n-1][j] == 'O') {
                dfs(n-1, j, board);
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }

            if (board[i][m-1] == 'O') {
                dfs(i, m-1, board);
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }

        board[i][j] = '#';
        for (int[] dir : dirs) {
            int R = dir[0] + i;
            int C = dir[1] + j;

            dfs(R, C, board);
        }
    }
}