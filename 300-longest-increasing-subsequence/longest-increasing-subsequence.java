class Solution {
    public int lengthOfLIS(int[] nums) {
        var lis = new ArrayList<Integer>();
        int len = nums.length;
        lis.add(nums[0]);

        for (int idx = 1; idx < len; ++idx) {
            int num = nums[idx];
            if (num > lis.getLast()) {
                lis.add(num);
            } else {
                int j = 0;
                while (num > lis.get(j)) {
                    j++;
                }
                lis.set(j, num);
            }
        }

        return lis.size();
    }
}