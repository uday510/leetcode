class Solution {
    public int numberOfSpecialChars(String word) {
        int[] cnt = new int[52];
        int n = word.length();

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (c - 'a' >= 0) {
                cnt[c - 'a']++;
            } else {
                cnt[(c - 'A') + 26]++;
            }
        }
        
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 &&  cnt[i + 26] > 0) {
                res++;
            }
        }

        return res;
    }
}