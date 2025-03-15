class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return dfs(nums, target, 0, 4);
    }
     private List<List<Integer>> dfs(int[] nums, long target, int i, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (k == 2) {
            int left = i;
            int right = nums.length - 1;

            while (left < right) {
                long sum = (long) nums[left] + (long) nums[right];
                if (sum < target) left++;
                else if (sum > target) right--;
                else {
                    res.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
            return res;
        }

        for (int idx = i; idx < (nums.length - k + 1); ++idx) {
            if (idx > i && (nums[idx] == nums[idx - 1])) continue;
            System.out.println(idx);
            List<List<Integer>> list = dfs(nums, target - nums[idx], idx + 1, k - 1);
            System.out.println(list);
            for (List<Integer> subList : list) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[idx]);
                temp.addAll(subList);
                res.add(temp);
            }
        }
        return res;
    }
}