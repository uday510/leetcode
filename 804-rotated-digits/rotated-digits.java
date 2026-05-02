class Solution {

    Set<Integer> invalid = Set.of(
        3, 4, 7
    );

    Set<Integer> valid = Set.of(
        2, 5, 6, 9
    );
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

            if (invalid.contains(cur)) return false;

            if (valid.contains(cur)) {
                safe = true;
            }

            num /= 10;
        }

        return safe;
    }
}