class Solution {
    public int sortPermutation(int[] nums) {
        int k = -1;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {

            if (nums[i] == i) continue;

            if (k == -1) k = nums[i];
            else k &= nums[i];
        }


        return k == -1 ? 0 : k;
    }
}