class Solution {

    Set<Integer> dia, anti, col;
    int n;
    char[][] board;
    List<List<String>> boards;
    private final char QUEEN = 'Q';
    private final char EMPTY = '.';

    public List<List<String>> solveNQueens(int n) {
        initialize(n);

        dfs(0);

        return boards;
    }

    private void dfs(int i) {
        if (i >= n) {
            boards.add(generateNewBoard());
            return;
        }

        for (int j = 0; j < n; j++) {
            int d = i - j, a = i + j;
            if (dia.contains(d) || anti.contains(a) || col.contains(j)) continue;

            dia.add(d); anti.add(a); col.add(j);

            board[i][j] = QUEEN;
            
            dfs(i + 1);

            dia.remove(d); anti.remove(a); col.remove(j);

            board[i][j] = EMPTY;
        }
    }

    private void initialize(int n) {
        dia = new HashSet<>();
        anti = new HashSet<>();
        col = new HashSet<>();
        this.n = n;
        board = new char[n][n];
        boards = new ArrayList<>();

        for (char[] row : board) Arrays.fill(row, EMPTY);
    }
    
    private List<String> generateNewBoard() {
        List<String> list = new ArrayList<>();

        for (char[] row : board) {
            list.add(String.valueOf(row));
        }

        return list;
    }
}