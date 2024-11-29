class Solution {
    int[][] DIRs = {
        {0, 1},
        {1, 0},
        {-1, 0},
        {0, -1}
    };
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

      PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));

      Set<String> seen = new HashSet<>();
      int END_ROW = grid.length - 1;
      int END_COL = grid[0].length - 1;

      priorityQueue.offer(new Node(0, 0, 0));
      seen.add(0 + ":" + 0);

      while (!priorityQueue.isEmpty()) {
        Node currentNode = priorityQueue.poll();
        int currentRow = currentNode.row;
        int currentCol = currentNode.col;
        int currentTime = currentNode.time;

        if (currentRow == END_ROW && currentCol == END_COL) {
            return currentTime;
        }

        for (int[] direction : DIRs) {
            int nextRow = direction[0] + currentRow;
            int nextCol = direction[1] + currentCol;
            int nextTime = currentTime + 1;
            String key = nextRow + ":" + nextCol;
            
            if (nextRow < 0 || nextRow > END_ROW || nextCol < 0 || nextCol > END_COL || seen.contains(key))  {
                    continue;
            }

            if (grid[nextRow][nextCol] > nextTime) {
                    int waitTime = grid[nextRow][nextCol] - nextTime;
                    if (waitTime % 2 == 1) { 
                        waitTime++;
                    }
                    nextTime += waitTime;
                }

            priorityQueue.offer(new Node(nextRow, nextCol, nextTime));
            seen.add(key);
        }
      }
      
      return -1;
    }

    private class Node {
        int row;
        int col;
        int time;

        Node (int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}