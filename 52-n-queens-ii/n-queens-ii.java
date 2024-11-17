class Solution {
    boolean[] cols;
    boolean[] diagonal;
    boolean[] antiDiagonal;
    int res;
    public int totalNQueens(int n) {
        String[][] matrix = new String[n][n];

        for (String[] row : matrix) Arrays.fill(row, ".");

        cols = new boolean[n];
        diagonal = new boolean[2 * n-1];
        antiDiagonal = new boolean[2 * n-1];
        res = 0;

        solveNQueens(matrix, 0, n);

        return res;
    }
    public void solveNQueens(String[][] matrix, int row, int n) {
        if (row == n) {
            res++;
            return;
        }

        for (int col = 0; col < n; ++col) {
            if (isQueenSafe(row, col, n)) {
                matrix[row][col] = "Q";
                cols[col] = true;
                antiDiagonal[row + col] = true;
                diagonal[row - col + n - 1] = true;
                solveNQueens(matrix, row + 1, n);
                matrix[row][col] = ".";
                cols[col] = false;
                antiDiagonal[row + col] = false;
                diagonal[row - col + n - 1] = false;
            }
        }
    }
    public boolean isQueenSafe(int row, int col, int n) {
        return (!cols[col] && !diagonal[row - col + n - 1] && !antiDiagonal[row + col]);
    }
    public static boolean isQueenSafe(String[][] matrix, int row, int col, int n) {
        // check for every row above on same col;
        for (int i = 0; i < row; ++i) {
            if (Objects.equals(matrix[i][col], "Q")) return false;
        }
        // check for left diagonal
        for (int i = row - 1, j = col - 1; i > -1 && j > -1; --i, --j) {
            if (Objects.equals(matrix[i][j], "Q")) return false;
        }
        // check for right diagonal
        for (int i = row - 1, j = col + 1; i > -1 && j < n; --i, ++j) {
            if (Objects.equals(matrix[i][j], "Q")) return false;
        }
        return true;
    }
    
     public static List<String> addPath(String[][] matrix) {
        List<String> path = new ArrayList<>();
        for (String[] m : matrix) {
            String temp = String.join("", m);
            path.add(temp);
        }
        return path;
    }
}