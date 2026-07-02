import java.util.*;

class Solution {

    private static final int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        if (health <= grid.getFirst().getFirst()) 
            return false;

        int m = grid.size();
        int n = grid.getFirst().size();
        int unk = Integer.MAX_VALUE;

        int[][] dist = new int[m][n];

        for (int[] r : dist)
            Arrays.fill(r, unk);

        Deque<int[]> queue = new ArrayDeque<>();

        dist[0][0] = grid.getFirst().getFirst();
        queue.offer(new int[] { 0, 0 });

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int x = cur[0], y = cur[1], w1 = dist[x][y];

            if (x == m - 1 && y == n - 1) return true;

            for (int[] nxt : DIRs) {
                int nx = nxt[0] + x;
                int ny = nxt[1] + y;

                if (!(nx > -1 && nx < m && ny > -1 && ny < n))
                    continue;

                int w2 = w1 + grid.get(nx).get(ny);
                
                if ( w2 >= health || w2 >= dist[nx][ny])
                    continue;
                
                dist[nx][ny] = w2;
                if (grid.get(nx).get(ny) == 0) {
                    queue.offerFirst(new int[] {nx, ny});
                } else {
                    queue.offerLast(new int[] {nx, ny});
                }

            }
        }

        return false;
    }
}

