class Solution {

    private int[] nums;
    private int n;

    public List<List<Integer>> threeSum(int[] nums) {
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

            for (List<Integer> sub : dfs(j + 1, k - 1, target - nums[j])) {
                List<Integer> cur = new ArrayList<>();
                cur.add(nums[j]);
                cur.addAll(sub);

                res.add(cur);
            }

        }

        return res;
    }

    private List<List<Integer>> twoSum(int idx, int target) {
        List<List<Integer>> list = new ArrayList<>();

        int i = idx, j = n - 1;

        while (i < j) {
            int cur = nums[i] + nums[j];

            if (cur < target) i++;
            else if (cur > target) j--;
            else {
                list.add(Arrays.asList(nums[i++], nums[j--]));

                while (i < n && nums[i - 1] == nums[i]) i++;
                while (j > -1 && nums[j] == nums[j + 1]) j--;
            }
        }

        return list;
    }
}