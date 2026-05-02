class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int n = 9;
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }   

        for (int r = 0; r < n; r++) {

            for (int c = 0; c < n; c++) {

                char ch = board[r][c];

                if (ch == '.') continue; // empty


                int boxId = ((r / 3) * 3) + (c / 3);

                if (
                    rows[r].contains(ch) || 
                    cols[c].contains(ch) || 
                    boxes[boxId].contains(ch)
                ) {
                    return false;
                }

                rows[r].add(ch);
                cols[c].add(ch);
                boxes[boxId].add(ch);
            }
        }




        return true;
    }
}