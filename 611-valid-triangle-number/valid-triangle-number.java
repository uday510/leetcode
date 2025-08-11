class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int cnt = 0, n = nums.length;

        for (int c = n - 1; c > 1; --c) {
            int a = 0, b = c - 1;

            while (a < b) {
                if (nums[a] + nums[b] > nums[c]) {
                    cnt += b - a;
                    b--;
                } else a++;
            }
        }

        return cnt;
    }
}

/**

2 3 4 4




 */