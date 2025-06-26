class Solution {
    int n;
    List<Integer> lis;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        lis = new ArrayList<Integer>();

        for (int i = 0; i < n; ++i) {
            int index = bisectLeft(nums[i]);
            if (index == lis.size()) lis.add(nums[i]);
            lis.set(index, nums[i]);
        } 
        
        return lis.size();
    }
    private int bisectLeft(int target) {
        int leftIdx = 0, rightIdx = lis.size();

        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) >> 1;
            if (lis.get(midIdx) < target) leftIdx = midIdx + 1;
            else rightIdx = midIdx;
        }

        return leftIdx;
    }
}