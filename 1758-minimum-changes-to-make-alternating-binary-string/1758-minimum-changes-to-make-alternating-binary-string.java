class Solution {
    public int minOperations(String s) {
        return Math.min(minOps(s, '0'), minOps(s, '1'));
    }

    public int minOps(String s, char start) {
        int ops = 0;
        for (char c : s.toCharArray()) {
            ops += (c == start) ? 0 : 1;
            start = (char) (start ^ 1);
        }
        return ops;
    }
}
