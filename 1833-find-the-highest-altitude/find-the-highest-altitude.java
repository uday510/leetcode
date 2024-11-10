class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int curr = 0;

        for (int g : gain) {
            curr += g;
            res = Math.max(curr, res);
        }
        return Math.max(0, res);
    }
}