class Solution {
    public String smallestPalindrome(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;

        StringBuilder sb = new StringBuilder();
        char m = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) m = (char) ('a' + i);
            for (int k = cnt[i] / 2; k > 0; k--) sb.append((char) ('a' + i));
        }

        StringBuilder res = new StringBuilder(sb);
        if (m != 0) res.append(m);

        return res.append(sb.reverse()).toString();
    }
}