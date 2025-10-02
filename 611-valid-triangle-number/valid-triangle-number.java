class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, cnt = 0;

        for (int k = n - 1; k > 1; k--) {
            int i = 0, j = k - 1;

            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    cnt += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return cnt;
    }
}

/**


[2, 3, 4, 4]

k = 4
res = 2,4,4  3,4,4, 2,3,4 2,3,4



 */