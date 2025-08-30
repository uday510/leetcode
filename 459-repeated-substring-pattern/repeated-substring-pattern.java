class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for (int len = 1; len * 2 <= n; len++) {
            if (n % len != 0) continue;

            boolean ok = true;

            for (int i = len; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - len)) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) return true;
        }

        return false;
    }
}

/**

"abab"




 */