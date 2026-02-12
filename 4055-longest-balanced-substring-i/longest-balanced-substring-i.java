class Solution {
    public int longestBalanced(String s) {
        int n = s.length(), longest = 0;

        int[] cnt = new int[26];
        boolean flag;

        for (int i = 0; i < n; i++) {
            Arrays.fill(cnt, 0);

            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';

                cnt[idx]++;
                flag = true;
                for (int c : cnt) {
                    if (c > 0 && c != cnt[idx]) {
                        flag = false;
                        break;
                    }
                }

                longest = flag ? Math.max(longest, j - i + 1) : longest;
            }
        }

        return longest;
    }
}