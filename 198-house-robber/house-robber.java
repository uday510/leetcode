class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int robbed = Math.max(num + rob1, rob2);

            rob1 = rob2;
            rob2 = robbed;
        }

        return Math.max(rob1, rob2);
    }
}