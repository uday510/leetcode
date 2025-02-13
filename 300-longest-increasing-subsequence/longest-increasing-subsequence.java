class Solution {
    List<Integer> lis;
    public int lengthOfLIS(int[] nums) {
        lis = new ArrayList<>();
        lis.add(nums[0]);
        
        for (int idx = 0; idx < nums.length; ++idx) {
            int num = nums[idx];
            int index = bs(num);
            if (index == lis.size()) 
                lis.add(num);
            lis.set(index, num);
           
        }

        return lis.size();
    }
    private int bs(int num) {
        int left = 0;
        int right = lis.size();

        while (left < right) {
            int mid = (left + right) >> 1;
            if (lis.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}