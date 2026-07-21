class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        
        int n = s.length();
        int ones = 0;

        for (int i = 0; i < n; i++) {
            ones += s.charAt(i) == '1' ? 1 : 0;
        }

        if (ones == n || ones == 0)
            return ones;

        int mx = ones;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') continue;
        
            int idx = i - 1;
            int l = 0, r = 0;
            while (idx > -1 && s.charAt(idx) == '1') idx--;

            while (idx > -1 && s.charAt(idx) == '0') {
                idx--;
                l++;
            }

            if (idx == i - 1) continue;

            idx = i + 1;
            while (idx < n && s.charAt(idx) == '1') idx++;

            i = idx - 1;

            while (idx < n && s.charAt(idx) == '0') {
                idx++;
                r++;
            }

            if (idx == i + 1 || l == 0 || r == 0) continue;

            mx = Math.max(mx, ones + l + r);

        }

        return mx;
    }
}