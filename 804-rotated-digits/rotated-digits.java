class Solution {

    static boolean[] invalid = new boolean[10];
    static boolean[] valid = new boolean[10];

    static {
        invalid[3] = invalid[4] = invalid[7] = true;
        valid[2] = valid[5] = valid[6] = valid[9] = true;
    }

    public int rotatedDigits(int n) {
        
        int cnt = 0;

        for (int i = 1; i <= n; i++) {

            boolean ok = isGood(i);
            if (ok) {
                cnt++;
            }

        }

        return cnt;
    }

    private boolean isGood(int num) {

        boolean safe = false;

        while (num > 0) {
            int cur = num % 10;

            if (invalid[cur]) return false;

            if (valid[cur]) {
                safe = true;
            }

            num /= 10;
        }

        return safe;
    }
}