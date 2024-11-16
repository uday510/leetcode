import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer, int[]> map = new HashMap<>();
        makeMapping(board, map, n);

        var queue = new LinkedList<Integer>();
        queue.offer(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int nextMove = curr + 1; nextMove <= Math.min(curr + 6, n * n); nextMove++) {
                    if (visited.contains(nextMove)) continue;
                    visited.add(nextMove);

                    int[] nextPos = map.get(nextMove);
                    int row = nextPos[0];
                    int col = nextPos[1];

                    int finalMove = board[row][col] == -1 ? nextMove : board[row][col];

                    if (finalMove == n * n) {
                        return moves;
                    }
                    queue.offer(finalMove);
                }
            }
        }
        return -1;
    }

    private void makeMapping(int[][] board, Map<Integer, int[]> map, int n) {
        int num = 1;
        boolean right = true;

        for (int i = n - 1; i >= 0; i--) {
            if (right) {
                for (int j = 0; j < n; j++) {
                    map.put(num++, new int[]{i, j});
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    map.put(num++, new int[]{i, j});
                }
            }
            right = !right;
        }
    }
}
