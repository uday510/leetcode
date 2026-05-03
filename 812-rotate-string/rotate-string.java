class Solution {
    public boolean rotateString(String s, String g) {
        if (s.length() != g.length()) {
            return false;
        }

        int n = s.length();

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == g.charAt(0)) {

                boolean ok = isValid(s, g, i, n);
                if (ok) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(String s, String g, int st, int n) {

        for (int i = 0; i < n; i++) {
            int idx = (i + st) % n;

            if (s.charAt(idx) != g.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}