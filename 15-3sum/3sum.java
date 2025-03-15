class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; ++i) {
            // Skip duplicate 'i' values to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            twoSum(i, nums, list);
        }

        return list;
    }

    private void twoSum(int i, int[] nums, List<List<Integer>> list) {
        int j = i + 1, k = nums.length - 1;

        while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum < 0) j++;
            else if (sum > 0) k--;
            else {
                list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++; k--;

                while (j < k && nums[j] == nums[j - 1]) j++;
                while (j < k && nums[k] == nums[k + 1]) k--;
            }
        }
    }
}