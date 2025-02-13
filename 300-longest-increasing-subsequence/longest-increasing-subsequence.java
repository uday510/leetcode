class Solution {
    List<Integer> lis;
    int len;
    public int lengthOfLIS(int[] nums) {
        lis = new ArrayList<Integer>();
        len = nums.length;
        lis.add(nums[0]);

        for (int idx = 1; idx < len; ++idx) {
            int num = nums[idx];
            if (num > lis.getLast()) {
                lis.add(num);
            } else {
                int j = bs(num);
                lis.set(j, num);
            }
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