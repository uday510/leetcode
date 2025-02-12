class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] length = new int[len];
        int[] count = new int[len];
        int longest = -1;
        
        for (int i = 0; i < len; ++i) {
            length[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
            longest = Math.max(longest, length[i]);
        }
        
        int result = 0;
        for (int idx = 0; idx < len; ++idx) {
            result += length[idx] == longest ? count[idx] : 0;
        }
        
        return result;
    }
}