class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> threeSum(int[] nums) {
        list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 || nums[i] != nums[i-1]) {
                twoSum(i, nums);
            }
        }

        return list;
    }

    private void twoSum(int i, int[] nums) {
        int j = i + 1;
        int k = nums.length - 1;

        while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum < 0) j++;
            else if (sum > 0) k--;
            else {
                list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));

                j++;
                k--;
                while (j < k && nums[j] == nums[j-1]) {
                    j++;
                }
            }
        }
    }
}