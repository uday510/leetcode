class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            int index = bisectLeft(lis, num);
            if (index == lis.size())
                lis.add(num);
            lis.set(index, num);
        }
        return lis.size();
    }
    private int bisectLeft(List<Integer> lis, int num) {
        int left = 0;
        int right = lis.size();

        while (left < right) {
            int mid = (left + right) >> 1;
            if (lis.get(mid) >= num) 
                right = mid;
            else left = mid + 1;
        }
        return left;
    }
}