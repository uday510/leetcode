class Solution {
    public long minimumSteps(String s) {
        long swaps = 0;
        int len = s.length();
        int white_pos = 0;
        char WHITE = '0';

        for (int idx = 0; idx < len; ++idx) {
            char c = s.charAt(idx);
            if (c != WHITE) {
               continue;
            }
            swaps += (idx - white_pos);
            ++white_pos;
        }
        return swaps;
    }
}