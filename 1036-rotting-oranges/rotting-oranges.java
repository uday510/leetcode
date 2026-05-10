class Solution {

    private int[][] DIRs = { {0,1}, {1,0}, {-1,0}, {0,-1} };

    public int orangesRotting(int[][] grid) {
        
        int numRows = grid.length;
        int numCols = grid[0].length;

        boolean[][] vis = new boolean[numRows][numCols];

        Queue<int[]> queue = new ArrayDeque<>();

        int fresh = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {

                if (grid[i][j] == 2) { // rotten
                    queue.offer(new int[] {i, j});
                    vis[i][j] = true;
                } 

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int mins = -1;

        while (!queue.isEmpty()) {
            
            mins++;
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];

                for (int[] dir : DIRs) {
                    int nx = dir[0] + x; // new row
                    int ny = dir[1] + y; // new col

                    if (
                        nx < 0 || nx >= numRows ||  // out of bounds
                        ny < 0 || ny >= numCols || // // out of bounds
                        vis[nx][ny]  // visited
                        || grid[nx][ny] != 1 // not fresh
                        ) {

                        continue;
                    }

                    fresh--;
                    vis[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});

                }

            }
 
        }

        if (fresh != 0) return -1;

        return mins;
    }
}