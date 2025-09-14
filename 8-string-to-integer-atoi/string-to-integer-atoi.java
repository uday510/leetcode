class Solution {
    final int MAX = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;

    public int myAtoi(String s) {
        int n = s.length(), i = 0;
        int sign = 1;
        long num = 0;

        while (i < n && s.charAt(i) == ' ') i++;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }

        while (i < n && s.charAt(i) == '0') i++;

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            num = num * 10 + digit;

            if (sign == 1 && num > MAX) return MAX;
            if (sign == -1 && -num < MIN) return MIN;

            i++;
        }

        return sign * (int) num;
    }
}