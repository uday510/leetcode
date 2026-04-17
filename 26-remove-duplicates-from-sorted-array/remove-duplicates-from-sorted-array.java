class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int cnt = 1;

        for (int idx = 1; idx < nums.length; ++idx) {
            if (nums[idx] == nums[idx - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }

            if (cnt == 1) {
                nums[index++] = nums[idx];
            }
        }

        System.out.println(Arrays.toString(nums));

        return index;
    }
}