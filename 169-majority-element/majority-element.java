class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = -1;
        int count = 0;

        for (int idx = 0; idx < nums.length; ++idx) {
            if (count == 0) {
                majorityElement = nums[idx];
            }

            if (majorityElement == nums[idx]) {
                count++;
            } else {
                count--;
            }
        }

        return majorityElement;
    }
}

/***

majorityElement = 2
count = 1

[2,2,1,1,1,2,2]



 */