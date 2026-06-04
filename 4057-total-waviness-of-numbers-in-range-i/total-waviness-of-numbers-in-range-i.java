class Solution {
    public int totalWaviness(int num1, int num2) {
        if (num2 < 3) return 0;

        int cnt = 0;

        for (int i = num1; i <= num2; i++) {
            cnt += ok(i);
        }

        return cnt;
    }

    private int ok(int num) {
        String s = String.valueOf(num);
        int cnt = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            int p = s.charAt(i - 1) - '0', 
            c = s.charAt(i) - '0', n = s.charAt(i + 1) - '0';

            if ((p < c && c > n) || (p > c && c < n)) {
                cnt++;
            }
        }

        return cnt;
    }
}


// 12013