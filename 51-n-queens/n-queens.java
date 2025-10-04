class Solution {
    Set<Integer> dia, anti, col;
    int n;
    char[][] board;
    List<List<String>> boards;

    public List<List<String>> solveNQueens(int n) {
        initialize(n);
        generateEmptyBoard();

        dfs(0);
        return boards;
    }
    private void dfs(int r) {
        if (r >= n) {
            boards.add(generateNewBoard());
            return;
        }

        for (int c = 0; c < n; c++) {
            int d = r - c, a = r + c;
            if (dia.contains(d) || anti.contains(a) || col.contains(c)) continue;

            dia.add(d);
            anti.add(a);
            col.add(c);
            board[r][c] = 'Q';

            dfs(r + 1);

            dia.remove(d);
            anti.remove(a);
            col.remove(c);
            
            board[r][c] = '.';
        }

    }

    private void initialize(int n) {
        dia = new HashSet<>();
        anti = new HashSet<>();
        col = new HashSet<>();
        this.n = n;
        board = new char[n][n];
        boards = new ArrayList<>();
    }

    private void generateEmptyBoard() {
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
    }

    private List<String> generateNewBoard() {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String r = String.valueOf(board[i]);
            list.add(r);
        }
        
        return list;
    }
}

/**

n = 4

    0 1 2 3
  0 Q - - -
  1 - Q - -
  2 - - - -
  3 - - - -


[

    [
        - Q - -,
        - - - Q,
        Q - - -,
        - - Q -
    ],
    [
        - - Q -,
        Q - - -,
        - - - Q,
        - Q - -
    ]

]




 */