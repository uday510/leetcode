class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (!valid(board, i, j)) 
                    return false;
            }
        }
        return true;
    }
    private boolean valid(char[][] board, int row, int col) {
       return (
            validRow(board, row) && 
            validCol(board, col) && 
            validBox(board, row - (row % 3), col - (col % 3)
       )); 
    }
    private boolean validRow(char[][] board, int row) {
        var set = new HashSet<Character>();
        for (int j = 0; j < 9; ++j) {
            char c = board[row][j];

            if (set.contains(c)) return false;

            if (c != '.') set.add(c);
        }
        return true;
    }
    private boolean validCol(char[][] board, int col) {
        var set = new HashSet<Character>();
        for (int i = 0; i < 9; ++i) {
            char c = board[i][col];

            if (set.contains(c)) return false;

            if (c != '.') set.add(c);
        }
        return true;
    } 
    private boolean validBox(char[][] board, int row, int col) {
        var set = new HashSet<Character>();
        for(int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                char c = board[i+row][j+col];

                if (set.contains(c))  return false;

                if (c != '.') set.add(c);
            }
        } return true;
    }
}