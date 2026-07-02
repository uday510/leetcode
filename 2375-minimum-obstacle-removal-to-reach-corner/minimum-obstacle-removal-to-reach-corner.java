import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    public int minimumObstacles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int unk = Integer.MAX_VALUE;

        for (int[] r : dist)
            Arrays.fill(r, unk);

        Deque<int[]> queue = new ArrayDeque<>();

        dist[0][0] = grid[0][0] == 0 ? 0 : 1;
        queue.offerFirst(new int[] {0, 0, dist[0][0]});

        int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int dx = cur[0], dy = cur[1], w = cur[2];
            
            if (dx == m - 1 && dy == n - 1)
                return w;

            for (int[] nxt : DIRs) {
                int nx = nxt[0] + dx, ny = nxt[1] + dy;

                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;

                int w1 = w + grid[nx][ny];
                
                if (w1 < dist[nx][ny]) {
                    
                    dist[nx][ny] = w1;
                    if (grid[nx][ny] == 0) {
                        queue.offerFirst(new int[] {nx, ny, w1});
                    } else {
                        queue.offerLast(new int[] {nx, ny, w1});
                    }
                }
            }
        }

        return -1;
    }

}