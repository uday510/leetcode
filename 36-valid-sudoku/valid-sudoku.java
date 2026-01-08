class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int n = 9;
        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] cols = new HashSet[n];
        Set<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                char ch = board[r][c];

                if (ch == '.') continue;

                int boxId = ((r / 3) * 3) + c / 3;

                if (!rows[r].add(ch) || !cols[c].add(ch) || !boxes[boxId].add(ch)) {
                    return false;
                }
            }
        }

        return true;
    }
}