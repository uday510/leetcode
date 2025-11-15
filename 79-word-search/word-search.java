class Solution {

    char[][] board;
    String w;
    int n, m, wLen;
    boolean[][] vis;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        this.board = board; 
        w = word;
        n = board.length;
        m = board[0].length;
        wLen = w.length();
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0)) return true;
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

            if (dfs(R, C, idx + 1)) return true;
        }

        return vis[x][y] = false;
    }

    private boolean isValid(int i, int j, int idx) {
        return (i >= 0 && i < n && j >= 0 && j < m && !vis[i][j] && board[i][j] == w.charAt(idx));
    }
}