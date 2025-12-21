class Solution {

    private int rows, cols;
    private boolean[] sorted;
    private String[] strs;

    public int minDeletionSize(String[] strs) {
        initialize(strs);
        int numDeletions = 0;

        for (int col = 0; col < cols; col++) {
            if (!isValidCol(col)) {
                numDeletions++;
            } else {
                updateRows(col);
            }
        }

        return numDeletions;
    }

    private boolean isValidCol(int col) {
        for (int row = 0; row < rows - 1; row++) {
            if (!sorted[row] && strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                return false;
            }
        }
        return true;
    }

    private void updateRows(int col) {
        for (int row = 0; row < rows - 1; row++) {
            if (strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                sorted[row] = true;
            }
        }
    }

    private void initialize(String[] strs) {
        this.strs = strs;
        rows = strs.length; 
        cols = strs[0].length();
        sorted = new boolean[rows - 1];
    }

}