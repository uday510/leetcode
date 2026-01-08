class Solution {

    Set<Integer> dia, anti, col;
    int n;
    char[][] board;
    List<List<String>> boards;
    char Q = 'Q';
    char E = '.';

    public List<List<String>> solveNQueens(int n) {
        initialize(n);

        dfs(0);

        return boards;
    }

    private void dfs(int i) {
        if (i >= n) {
            boards.add(genBoard());
            return;
        }

        for (int j = 0; j < n; j++) {
            int d = i - j, an = i + j;

            if (dia.contains(d) || anti.contains(an) || col.contains(j)) continue;

            dia.add(d); anti.add(an); col.add(j);

            board[i][j] = Q;

            dfs(i + 1);

            dia.remove(d); anti.remove(an); col.remove(j);

            board[i][j] = E; 
        }
    }

    private void initialize(int n) {
        dia = new HashSet<>();
        anti = new HashSet<>();
        col = new HashSet<>();
        this.n = n;
        board = new char[n][n];
        boards = new ArrayList<>();

        for (char[] row : board) Arrays.fill(row, E);
    }

    private List<String> genBoard() {
        List<String> list = new ArrayList<>();

        for (char[] row : board) {
            list.add(String.valueOf(row));
        } 

        return list;
    }
}