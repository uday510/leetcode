class Solution {

    private int len;
    private int[] prefixSum;
    private boolean[] result;

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {

        intialize(nums.length, queries.length);
        findPrefixSum(nums);
        findResult(queries);

        return result;
    }

    private void findResult(int[][] queries) {

        for (int idx = 0; idx < queries.length; ++idx) {
            int[] query = queries[idx];

            result[idx] = prefixSum[query[1]] - prefixSum[query[0]] == 0;

        }
    }

    private void findPrefixSum(int[] nums) {
        for (int idx = 1; idx < len; ++idx) {
            prefixSum[idx] = prefixSum[idx - 1];

            if (nums[idx] % 2 == nums[idx - 1] % 2) {
                ++prefixSum[idx];
            } 
        }
    }

    private void intialize(int len1, int len2) {
        this.len = len1;
        this.prefixSum = new int[len];
        this.result = new boolean[len2];
    }

}