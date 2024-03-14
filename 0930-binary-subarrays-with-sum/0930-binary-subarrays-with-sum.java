class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;
        int len = nums.length;

        while (j < len) {
            sum += nums[j];

            while (i < j && sum > goal) {
                sum -= nums[i];
                i++;
            }

            if (sum == goal) {
                int left = i;
                int zeros = 1;
                while (left < j && nums[left] == 0) {
                    left++;
                    zeros++;
                }
                count += zeros;
                System.out.println(i + " " + j + " " + count);
            }
            j++;
        }
        return count;
    }
}