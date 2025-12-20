class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length, cols = strs[0].length();
        int cnt = 0;
        boolean valid;

        for (int c = 0; c < cols; c++) {
            valid = true;
            for (int r = 1; r < rows && valid; r++) {

                valid = getAscii(strs[r].charAt(c)) - getAscii(strs[r - 1].charAt(c)) >= 0;
                cnt += !valid ? 1 : 0;
            }
        }

        return cnt;
    }

    private int getAscii(char ch) {
        return ch - 'a';
    }
}