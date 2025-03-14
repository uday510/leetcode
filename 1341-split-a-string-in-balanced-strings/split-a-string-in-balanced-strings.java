class Solution {
    public int balancedStringSplit(String s) {
        int L = 0;
        int R = 0;
        int cnt = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'L') L++;
            else R++;

            if (L == R) cnt++;
        }

        return cnt;
    }
}