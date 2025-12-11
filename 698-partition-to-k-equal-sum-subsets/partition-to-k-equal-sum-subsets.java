class Solution {

    int n, target;
    boolean[] used;
    int[] nums;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        this.nums = nums;
        used = new boolean[n];

        int totalSum = Arrays.stream(nums).sum();

        if (totalSum % k != 0) return false;

        target = totalSum / k;

        Arrays.sort(nums);

        if (nums[n - 1] > target) return false;

        return dfs(0, k, 0);
    }

    private boolean dfs(int i, int k, int curSum) {
        if (k == 1) return true;

        if (curSum == target) return dfs(0, k - 1, 0);

        for (int j = i; j < n; j++) {

            if (used[j] || curSum + nums[j] > target) continue;

            used[j] = true;
            if (dfs(j + 1, k, curSum + nums[j])) return true;
            used[j] = false;

            if (curSum == 0) break;
            if (curSum + nums[j] == target) break;
        }

        return false;
    }

}