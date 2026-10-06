class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, mismatch = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++open;
                continue;
            }

            int tmp = open == 0 ? ++mismatch : --open;
        }

        return mismatch + open;
    }
}