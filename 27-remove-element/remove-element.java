class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int idx = 0;

        for (; ;) {
            if (idx >=  nums.length) break;
            if (nums[idx] != val) 
                nums[index++] = nums[idx];

             ++idx;
        }

        return index;
    }
}
