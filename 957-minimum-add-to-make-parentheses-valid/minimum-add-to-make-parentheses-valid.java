class Solution {
    public int minAddToMakeValid(String s) {
        int stack = 0;
        int mismatch = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++stack;
            } else {
                if (stack == 0) {
                    ++mismatch;
                } else {
                    --stack;
                }
            }
        }
        return mismatch + stack;
    }
}