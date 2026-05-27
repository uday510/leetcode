class Solution {
    public int numberOfSpecialChars(String word) {
        int[] cnt = new int[52];
        int n = word.length();

        Arrays.fill(cnt, -1);

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (c - 'a' >= 0) {
                cnt[c - 'a'] = i;
            } else {
                if (cnt[c - 'A' + 26] == -1) cnt[c - 'A' + 26] = i;
            }
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += (cnt[i] != -1 && cnt[i] < cnt[i + 26]) ? 1 : 0;
        }

        return res;

    }
}