class Solution {
    int n;

    public int lengthOfLIS(int[] nums) {
        this.n = nums.length;

        List<Integer> lis = new ArrayList<>();

        for (int idx = 0; idx < n; ++idx) {
             int index = bisectLeft(lis, nums[idx]);
             if (index == lis.size()) lis.add(nums[idx]);
             lis.set(index, nums[idx]);
        }
        return lis.size();
    }

    private int bisectLeft (List<Integer> lis, int target) {
        int leftIdx = 0, rightIdx = lis.size();

        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) >> 1;
            if (lis.get(midIdx) < target) leftIdx = midIdx + 1;
            else rightIdx = midIdx;
        }

        return leftIdx;
    }
}