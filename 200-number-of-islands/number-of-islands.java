class Solution {

    private char[][] grid;
    private int m, n;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    bfs(i, j);
                }
            }
        }

        return numIslands;
    }

    private void bfs(int x, int y) {
        Queue<Edge> queue = new ArrayDeque<>();
        grid[x][y] = '0';
        queue.offer(new Edge(x, y));

        while (!queue.isEmpty()) {
            Edge e = queue.poll();

            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (Math.abs(dx) + Math.abs(dy) != 1) continue;

                    int nx = dx + e.x, ny = dy + e.y;
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                        grid[nx][ny] = '0';
                        queue.offer(new Edge(nx, ny));
                    }
                }
            }
        }

    }

    class Edge {
        int x, y;
        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}