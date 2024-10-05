class Solution {
    int[] cnt1;
    int[] cnt2;
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        cnt1 = new int[128];
        cnt2 = new int[128];
         
        for (int idx = 0; idx < s1.length(); ++idx) {
            ++cnt1[getChar(s1, idx)];
            ++cnt2[getChar(s2, idx)];
        }

        if (validPerm()) {
            return true;
        }

        for (int start = 0, end = s1.length();  end < s2.length(); ++start, ++end) {
            --cnt2[getChar(s2, start)];
            ++cnt2[getChar(s2, end)];

            if (validPerm()) {
                return true;
            }
        }
        return false;
    }
    private char getChar(String s, int idx) {
        return s.charAt(idx);
    }
    private boolean validPerm() {
        for (int idx = 0; idx < 26; ++idx) {
            if (cnt1[97+idx] != cnt2[97+idx]) {
                return false;
            }
        }
        return true;
    }
}