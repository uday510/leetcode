class Solution {
    public int maximumCount(int[] nums) {
        int c1 = bs(0, nums) - 1;
        int c2 = bs(1, nums);
        
        int negativeCount = c1 + 1;
        int positiveCount = nums.length - c2; 
        System.out.println(c1 + " " + c2 + " " + negativeCount + " " + positiveCount);
        return Math.max(negativeCount, positiveCount);
    }

    private int bs(int target, int[] nums) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}