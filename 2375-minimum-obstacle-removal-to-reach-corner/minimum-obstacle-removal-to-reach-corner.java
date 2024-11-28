class Solution {
    int[][] DIRs = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    public int minimumObstacles(int[][] grid) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.obstacles - o2.obstacles);
        Set<String> vis = new HashSet<>();

        int endRow = grid.length - 1;
        int endCol = grid[0].length - 1;
        int OBSTACLE = 1;
        Node startNode = new Node(0, 0, 0);

        if (grid[0][0] == OBSTACLE) {
            startNode.obstacles = 1;
        }
        
        queue.offer(new Node(0, 0, grid[0][0]));

        vis.add(0 + ":" + 0);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int currentRow = node.row;
            int currentCol = node.col;
            int currentObstacles = node.obstacles;

            if (currentRow == endRow && currentCol == endCol) {
                return currentObstacles;
            }

            for (int[] direction : DIRs) {
                int nextRow = direction[0] + currentRow;
                int nextCol = direction[1] + currentCol;
                int obstacles = currentObstacles;
                String key = nextRow + ":" + nextCol;

               if (nextRow < 0 || nextRow >= grid.length || 
                   nextCol < 0 || nextCol >= grid[0].length ||
                    vis.contains(key)) {
                    continue;
               }

               if (grid[nextRow][nextCol] == OBSTACLE) {
                    ++obstacles;
               }
                
                vis.add(key);
                queue.offer(new Node(nextRow, nextCol, obstacles));
            }
        }

        return 0;
    }

    class Node {
        int row;
        int col;
        int obstacles;

        Node(int row, int col, int obstacles) {
            this.row = row;
            this.col = col;
            this.obstacles = obstacles;
        }
    }
}