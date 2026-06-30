class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] cnt = new int[3];
        int total = 0, n = s.length();
        int l = 0, r = 0;

        while(r < n) {
            cnt[s.charAt(r) - 'a']++;

            while (ok(cnt)) {
                total += (n - r);

                cnt[s.charAt(l++) - 'a']--;
            }

            r++;
        }

        return total;
    }

    private boolean ok(int[] cnt) {
        return cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0;
    }
}
