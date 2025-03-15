import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return dfs(nums, (long) target, 4, 0);
    }

    private List<List<Integer>> dfs(int[] nums, long target, int k, int i) {
        List<List<Integer>> res = new ArrayList<>();

        if (k == 2) {
            int left = i, right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[left] + (long) nums[right];

                if (sum < target) left++;
                else if (sum > target) right--;
                else {
                    res.add(Arrays.asList(nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++;

                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
            return res;
        }

        for (int idx = i; idx < nums.length - (k - 1); ++idx) {
            if (idx > i && nums[idx] == nums[idx - 1]) continue;

            List<List<Integer>> subResults = dfs(nums, target - nums[idx], k - 1, idx + 1);
            for (List<Integer> sub : subResults) {
                List<Integer> temp = new ArrayList<>(sub);
                temp.add(0, nums[idx]);
                res.add(temp);
            }
        }

        return res;
    }
}