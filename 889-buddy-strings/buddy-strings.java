class Solution {
    public boolean buddyStrings(String s, String g) {
        int n = s.length();
        int m = g.length();

        if (n != m) return false;

        int[] cnt1 = new int[128];
        int[] cnt2 = new int[128];

        int cnt = 0;
        for (int i = 0; i < n && cnt < 3; i++) {
            char ch1 = s.charAt(i);
            char ch2 = g.charAt(i);

            if (ch1 != ch2) cnt++;

            cnt1[ch1]++;
            cnt2[ch2]++;
        }

        if (cnt > 2) return false;

        if (cnt == 0) {
            int chars = 0;
            int ch2 = 0;
            for (int i = 0; i < 128; i++) {
                if (cnt1[i] == 1) chars++;
                else if (cnt1[i] > 1) ch2++;
            }
            if (ch2 == 0) return false;
        }
        
        for (int i = 0; i < 128; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }

        return true;
    }
}