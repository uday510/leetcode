class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length, cols = strs[0].length();
        int cnt = 0;

        for (int c = 0; c < cols; c++) {
            for (int r = 1; r < rows; r++) {

                boolean valid = getAscii(strs[r].charAt(c)) - getAscii(strs[r - 1].charAt(c)) >= 0;
                cnt += !valid ? 1 : 0;
                if (!valid) break;
            }
        }

        return cnt;
    }

    private int getAscii(char ch) {
        return ch - 'a';
    }
}