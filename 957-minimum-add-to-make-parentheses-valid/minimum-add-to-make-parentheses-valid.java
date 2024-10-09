class Solution {
    public int minAddToMakeValid(String s) {
        int stack = 0;
        int mismatch = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++stack;
                continue;
            }
            int temp = stack == 0 ? ++mismatch : --stack;
        }
        return mismatch + stack;
    }
}