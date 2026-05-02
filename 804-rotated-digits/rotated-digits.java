class Solution {
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

            if (cur == 3 || cur == 4 || cur == 7) return false;

            if (cur == 2 || cur == 5 || cur == 6 || cur == 9) {
                safe = true;
            }

            num /= 10;
        }

        return safe;
    }
}