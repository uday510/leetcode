class Solution {
    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {

      int left = 0;
      int right = 1000000;
      int res = right;

      while (left <= right) {
        int midIdx = (left + right) / 2;

        if (exists(heights, midIdx)) {
          res = midIdx;
          right = midIdx - 1;
        } else {
          left = midIdx + 1;
        }
      }
      return res;
    }

    boolean exists(int[][] heights, int k) {
      int row = heights.length;
      int col = heights[0].length;

      boolean[][] visited = new boolean[row][col];
      Queue<Cell> queue = new LinkedList<>();

      queue.offer(new Cell(0, 0));
      visited[0][0] = true;

      while (!queue.isEmpty()) {
          Cell cell = queue.poll();
          int x = cell.x;
          int y = cell.y;

          if (x == row - 1 && y == col - 1) {
            return true;
          }

          for (int[] dir : directions) {
            int adjX = x + dir[0];
            int adjY = y + dir[1];

            if (isValid(adjX, adjY, row, col) && !visited[adjX][adjY]) {
              
              int currDiff = Math.abs( heights[x][y] - heights[adjX][adjY]);

              if (currDiff <= k) {
                visited[adjX][adjY] = true;
                Cell newCell = new Cell(adjX, adjY);
                queue.offer(newCell);
              }
            }
          }
      }
      return false;
    }
    boolean isValid(int i, int j, int m, int n) {
      return (i > -1 && i < m && j > -1 && j < n);
    }
}
class Cell {
  int x;
  int y;

  Cell(int i, int j) {
    x = i;
    y = j;
  }
}