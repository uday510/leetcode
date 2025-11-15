class Solution {

    char[][] board;
    String w;
    int n, m, wLen;
    boolean[][] vis;

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

    private boolean dfs(int i, int j, int idx) {
        if (idx >= wLen) return true;

        if (!isValid(i, j, idx)) return false;

        vis[i][j] = true;
        if (dfs(i + 1, j, idx + 1) || 
            dfs(i - 1, j, idx + 1) || 
            dfs(i, j + 1, idx + 1) || 
            dfs(i, j - 1, idx + 1)) {
            return true;
        }

        vis[i][j] = false;
        return false;
    }

    private boolean isValid(int i, int j, int idx) {
        return (i >= 0 && i < n && j >= 0 && j < m && !vis[i][j] && board[i][j] == w.charAt(idx));
    }
}