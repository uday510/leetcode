class Solution {

    private int[] nums;
    private int n;

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();

        this.nums = nums;
        this.n = nums.length;

        Arrays.sort(nums);

        return dfs(0, 3, 0);
    }

    private List<List<Integer>> dfs(int i, int k, int target) {
        if (k == 2) return twoSum(i, target);

        List<List<Integer>> res = new ArrayList<>();

        for (int j = i; j < n; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;

            List<List<Integer>> subLists = dfs(j + 1, k - 1, target - nums[j]);

            for (List<Integer> sub : subLists) {
                List<Integer> cur = new ArrayList<>();
                cur.add(nums[j]);
                cur.addAll(sub);

                res.add(cur);
            }
        }

        return res;

    }

    private List<List<Integer>> twoSum (int index, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int i = index, j = n - 1;

        while (i < j) {
            int cur = nums[i] + nums[j];

            if (cur < target) i++;
            else if (cur > target) j--;
            else {
                list.add(Arrays.asList(nums[i], nums[j]));

                i++;
                j--;

                while (i < n && nums[i] == nums[i - 1]) i++;
                while (j > -1 && nums[j] == nums[j + 1]) j--;
            }
        }

        return list;
    }

}