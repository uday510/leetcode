class Solution {
    int[] nums;
    int n;
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        n = nums.length;
        
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int idx = bs(nums[i], lis);
            if (idx == lis.size()) lis.add(nums[i]);
            lis.set(idx, nums[i]);
        }

        return lis.size();
    }

   private int bs(int target, List<Integer> lis) {
    int left = 0, right = lis.size();

    while (left < right) {
        int mid = (left + right) >> 1;

        if (lis.get(mid) < target) left = mid + 1;
        else right = mid;
    }

    return left;
   }
}