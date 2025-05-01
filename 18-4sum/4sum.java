class Solution {
    private int[] nums;
    private int n;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) return result;

        this.nums = nums;
        this.n = nums.length;
        Arrays.sort(nums);

        return dfs(0, 4, target*1l);
    }
    private List<List<Integer>> dfs(int i, int k, long target) {
        if (k == 2) {
            return twoSum(i, target);
        }

        List<List<Integer>> result = new ArrayList<>();


        for (int idx = i; idx < n; ++idx) {
            if (idx > i && nums[idx] == nums[idx - 1]) continue;

            List<List<Integer>> subLists = dfs(idx + 1, k - 1, target - nums[idx]);

            for (var sub : subLists) {
                List<Integer> combination = new ArrayList<>();
                combination.add(nums[idx]);
                combination.addAll(sub);
                result.add(combination);
            }
        }



        return result;
    }

    private List<List<Integer>> twoSum(int idx, long target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = idx, right = n - 1;

        while (left < right) {
            int curr = nums[left] + nums[right];

            if (curr < target) left++;
            else if (curr > target) right--;
            else {
                result.add(Arrays.asList(nums[left], nums[right]));

                left++;
                right--;

                while (left < n && nums[left] == nums[left - 1]) left++;

                while (right > -1 && nums[right] == nums[right + 1]) right--;
            }
        }

        return result;
    }
}