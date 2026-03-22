class Solution {

    private char[][] B;
    private String w;
    private int n, m, wLen;
    private boolean[][] vis;
    private static final int[][] dirs = {
        {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

    public boolean exist(char[][] board, String word) {
        B = board;
        w = word;
        n = B.length;
        m = B[0].length;
        wLen = w.length();
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }   

    private boolean dfs(int i, int j, int idx) {
        if (idx >= wLen) return true;
        if (i >= n || i < 0 ||
             j < 0 || j >= m || 
            vis[i][j] || B[i][j] != w.charAt(idx)) return false;

        vis[i][j] = true;
        for (int[] dir : dirs) {
            int R = dir[0] + i, C = dir[1] + j;

            if (dfs(R, C, idx + 1)) {
                return true;
            }
        }

        vis[i][j] = false;
        return false;
    }
}