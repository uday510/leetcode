class Solution {
    public int rob(int[] arr) {
        int r1 = 0, r2 = 0;

        for (int a : arr) {
            int cur = Math.max(a + r1, r2);

            r1 = r2;
            r2 = cur;
        }

        return Math.max(r1, r2);
    }
}