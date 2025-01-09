class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(i, nums);
            }
        }

        return result;
    }
    private void twoSum(int idx, int[] nums) {
        int j = idx + 1;
        int k = nums.length - 1;

        while (j < k) {
            int sum = nums[idx] + nums[j] + nums[k];

            if (sum < 0) {
                j++;
            } else if (sum > 0) {
                k--;
            } else {
                result.add(new ArrayList<>(Arrays.asList(nums[idx], nums[j++], nums[k--])));
                while (j < k && nums[j] == nums[j-1]) {
                    j++;
                }
            }
        }
    }
}