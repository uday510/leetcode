class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int longest = 0;
        int i = 0, j = 0, n = nums.length;

        while (j < n) {

            while (i < j && (nums[j] - nums[i] > 1)) i++;

            if (nums[j] - nums[i] == 1) longest = Math.max(longest, j - i + 1);
            j++;
        }

        return longest;
    }
}