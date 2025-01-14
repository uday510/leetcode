class Solution {

    int[][] Dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    Queue<int[]> queue;
    int rows;
    int cols;
    int freshOranges;
    int minutes;

    public int orangesRotting(int[][] grid) {
        intialize(grid);

        if (freshOranges == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == -1 && current[1] == -1) {
                minutes++;
                if (!queue.isEmpty()) {
                    queue.offer(new int[]{-1, -1});
                }
                continue;
            }
            

            for (int[] dir : Dirs) {
                int newX = dir[0] + current[0];
                int newY = dir[1] + current[1];

                if (!valid(newX, newY, grid)) {
                    continue;
                }

                grid[newX][newY] = 2;

                System.out.println(newX + " " + newY);
                freshOranges--;
                queue.offer(new int[]{newX, newY});
            }           
        }

        return freshOranges == 0 ? minutes : -1;
    }

    private void intialize(int[][] grid) {
        queue = new LinkedList<>();
        freshOranges = 0;
        rows = grid.length;
        cols = grid[0].length;
        minutes = -1;

        for (int rowIdx = 0; rowIdx < rows; ++rowIdx) {
            for (int colIdx = 0; colIdx < cols; ++colIdx) {
                int current = grid[rowIdx][colIdx];

                if (current == 1) {
                    freshOranges++;
                }

                if (current == 2) {
                    queue.offer(new int[]{rowIdx, colIdx});
                }
            }
        }

        queue.offer(new int[]{-1, -1});
    }

    private boolean valid(int x,  int y, int[][] grid) {
        return !(x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 2 || grid[x][y] == 0);
    }
}
