class Solution {
    public int minimumLength(String s) {
        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int result = 0;

        for (int idx = 0; idx < 26; ++idx) {
            int curr = cnt[idx];

            result += curr > 0 ? (curr % 2 == 0 ? 2 : 1) : 0;
        }

        return result;
    }
}
