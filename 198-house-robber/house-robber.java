class Solution {
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for (int num : nums) {
            int rob = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = rob;
        }
        return Math.max(rob1, rob2);
    }
}