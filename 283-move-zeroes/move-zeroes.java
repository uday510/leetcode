class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0, n = nums.length;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) cnt++;
            else {
                nums[idx++] = nums[i];
            }
        }

        for (; idx < n; idx++) {
            nums[idx] = 0;
        }

    }
}