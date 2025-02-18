class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int count = 0;
        int prev = nums[0];

        for (int idx = 0; idx < nums.length; ++idx) {
            int curr = nums[idx];
            if (prev == curr) {
                count++;
            } else {
                count = 1;
                prev = curr;
            }

            if (count <= 2) {
                nums[index] = curr;
                index++;
            } 
        }

        return index;
    }
}
