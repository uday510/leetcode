class Solution {
    public int jump(int[] nums) {
        int n = nums.length, res = 0;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; i++) {
            curFar = Math.max(curFar, i + nums[i]);

            if (curEnd == i) {
                curEnd = curFar;
                res++;
            }
        }

        return res;
    }
}