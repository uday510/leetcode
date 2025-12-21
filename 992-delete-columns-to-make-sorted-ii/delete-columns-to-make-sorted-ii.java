class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int cols = strs[0].length();
        boolean[] sorted = new boolean[n - 1];
        int cnt = 0;

        for (int col = 0; col < cols; col++) {
            boolean invalid = false;

            // 1️⃣ Check validity
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] &&
                    strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    invalid = true;
                    break;
                }
            }

            if (invalid) {
                cnt++;
                continue;
            }

            // // 2️⃣ Update sorted
            for (int i = 0; i < n - 1; i++) {
                if (
                    strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                    sorted[i] = true;
                }
            }
        }

        return cnt;
    }
}