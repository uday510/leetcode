class Solution {
    static final int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int visited = 0;
        int[][] vis = new int[m][n];
        
        for (int[] g : guards) {
            int x = g[0], y = g[1];
            vis[x][y] = 2;
            visited++;
        }

        for (int[] w : walls) {
            int x = w[0], y = w[1];
            vis[x][y] = 2;
            visited++;
        }

        for (int[] g : guards) {
            int x = g[0], y = g[1];

            for (int[] dir : dirs) {
                int nx = dir[0] + x, ny = dir[1] + y;

                while (nx >= 0 && nx < m && ny >= 0 && ny < n && vis[nx][ny] < 2) {
                    if (vis[nx][ny] == 0) {
                        vis[nx][ny] = 1;
                        visited++;
                    }

                    nx += dir[0];
                    ny += dir[1];
                }
            }
        }

        return (m * n) - visited;
    }

}
