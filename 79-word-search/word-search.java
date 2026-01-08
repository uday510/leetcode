class Solution {

    char[][] board;
    String w;
    int n, m, wLen;
    boolean[][] vis;
    int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public boolean exist(char[][] board, String word) {
        this.board = board;
        w = word;
        n = board.length;
        m = board[0].length;
        wLen = w.length();
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (w.charAt(0) == board[i][j]) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int x, int y, int idx) {
        if (idx >= wLen) return true;

        if (!isValid(x, y, idx)) return false;

        vis[x][y] = true;
        for (int[] dir : dirs) {
            int R = dir[0] + x, C = dir[1] + y;

            if (dfs(R, C, idx + 1)) {
                return true;
            }

        }

        vis[x][y] = false;
        return false;
    }

    private boolean isValid(int x, int y, int idx) {
        return (
            x >= 0 && x < n &&
            y >= 0 && y < m &&
            !vis[x][y] && board[x][y] == w.charAt(idx)
        );
    }
}