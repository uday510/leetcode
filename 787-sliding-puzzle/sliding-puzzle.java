class Solution {
    private int[][] dir;
    private StringBuilder start;
    private Map<String, Integer> vis;
    public int slidingPuzzle(int[][] board) {
        intialize(board);

        dfs(start.toString(), start.indexOf("0"), 0);

        return vis.getOrDefault("123450", -1);
    }
    private void dfs(String currStr, int currPos, int currMoves) {

        if (vis.containsKey(currStr) && vis.get(currStr) <= currMoves) {
            return;
        }

        vis.put(currStr, currMoves);

        for (int nextPos : dir[currPos]) {
            String nextStr = swap(currStr, nextPos, currPos);

            dfs(nextStr, nextPos, currMoves + 1);
        }
    }

    private String swap(String currStr, int idx1, int idx2) {
        StringBuilder sb = new StringBuilder(currStr);

        sb.setCharAt(idx1, currStr.charAt(idx2));
        sb.setCharAt(idx2, currStr.charAt(idx1));

        return sb.toString();
    }
    private void intialize(int[][] board) {
        dir = new int[][]{
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {3, 5, 1},
            {2, 4}
        };

        start = new StringBuilder();

        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                start.append(board[i][j]);
            }
        }

        vis = new HashMap<>();

    }
}