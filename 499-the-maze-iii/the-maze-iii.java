class Solution {

    private final static int[][] dirs = { {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private final static String[] pathDirs = {"r", "l", "u", "d"};
    private final static int UNKNOWN = Integer.MAX_VALUE;
    private final static String IMPOSSIBLE = "impossible";
    private final static Queue<State> pq = new PriorityQueue<>((o1, o2) -> o1.w != o2.w ? o1.w - o2.w : o1.path.compareTo(o2.path));

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        pq.clear();
        int m = maze.length, n = maze[0].length;
        int[][] dists = new int[m][n];
        String[][] paths = new String[m][n];

        for (int[] row : dists) Arrays.fill(row, UNKNOWN);

        paths[ball[0]][ball[1]] = "";
        dists[ball[0]][ball[1]] = 0;
        pq.offer(new State(ball[0], ball[1], 0, ""));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int x = curState.x, y = curState.y, w = curState.w;
            String path = curState.path;

            if (x == hole[0] && y == hole[1]) return path;

            if (dists[x][y] < w) continue;

            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int nx = x, ny = y;
                int cnt = 0;

                while (
                    nx + dir[0] >= 0 && nx + dir[0] < m &&
                    ny + dir[1] >= 0 && ny + dir[1] < n &&
                    maze[nx + dir[0]][ny + dir[1]] == 0
                ) {

                    nx += dir[0];
                    ny += dir[1];
                    cnt++;

                    if (nx == hole[0] && ny == hole[1]) break;
                }

                String newPath = path + pathDirs[i];
                int w1 = w + cnt;

                if (
                    w1 < dists[nx][ny] ||
                    (w1 == dists[nx][ny] && (paths[nx][ny] == null || paths[nx][ny].compareTo(newPath) > 0))
                ) {
                    dists[nx][ny] = w1;
                    paths[nx][ny] = newPath;

                    pq.offer(new State(nx, ny, w1, newPath));
                }
                
            }   
        }


        return IMPOSSIBLE;

    }
}

class State {
    final int x;
    final int y;
    final int w;
    final String path;

    State (int x, int y, int w, String path) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.path = path;
    }
}