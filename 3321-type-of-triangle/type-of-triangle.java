class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (!canFormTriangle(nums)) return "none";

        if (nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
        
        if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) return "isosceles";

        return "scalene";
    }

    private boolean canFormTriangle(int[] nums) {
        return nums[0] + nums[1] > nums[2];
    }
}