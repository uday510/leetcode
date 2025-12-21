class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length, cols = strs[0].length();
        int numDeletions = 0;
        boolean[] sorted = new boolean[rows - 1];

        boolean invalid;
        for (int col = 0; col < cols; col++) {
            invalid = false;

            for (int row = 0; row < rows - 1; row++) {

                if (!sorted[row] && strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    invalid = true;
                    break;
                }

            }

            if (invalid) {
                numDeletions++;
                continue;
            }

            for (int row = 0; row < rows - 1; row++) {
                if (strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                    sorted[row] = true;
                }
            }

        }

        return numDeletions;
    }

}