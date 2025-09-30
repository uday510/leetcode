class Solution {
    public int maxPower(String s) {
        int cur = 0, longest = 0, n = s.length();
        char prev = ' ';

        for (int i = 0; i < n; i++) {
            if (prev == s.charAt(i)) {
                cur++;
            } else {
                cur = 1;
                prev = s.charAt(i);
            }
            longest = Math.max(longest, cur);
        }

        return longest;
    }
}