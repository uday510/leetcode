class Solution {

    String s;
    int n;

    public String longestPalindrome(String s) {
        int[] res = {0, 1};
        this.n = s.length();
        this.s = s;

        for (int i = 0; i < n; i++) {
            int[] odd = getLen(i - 1, i + 1);
            int[] even = getLen(i - 1, i);

            int[] cur = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            res = cur[1] - cur[0] > res[1] - res[0] ? cur : res;
        }

        return s.substring(res[0], res[1]);
    }

    private int[] getLen(int i, int j) {
        while (i > -1 && j < n && s.charAt(i) == s.charAt(j)) {
            i--; j++;
        }

        return new int[] {i + 1, j};
    }
}