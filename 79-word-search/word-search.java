class Solution {
    private int m;
    private int n;
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        intialize(board);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (search(0, i, j, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean search(int index, int i, int j, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }

        if (!valid(index, i, j, board, word)) {
            return false;
        }


        visited[i][j] = true;

        if (
            search(index + 1, i + 1, j, board, word) || 
            search(index + 1, i - 1, j, board, word) || 
            search(index + 1, i, j + 1, board, word) ||
            search(index + 1, i, j - 1, board, word)
            )
             {
                return true;
            }

        return visited[i][j] = false;
    }
    private boolean valid(int index, int i, int j, char[][] board, String word) {
        return !(i < 0 || i >= m || j < 0 || j >= n ||
                 board[i][j] != word.charAt(index) ||  
                 visited[i][j]);
    }
    private void intialize(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
    }
}