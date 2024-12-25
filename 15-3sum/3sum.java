class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> threeSum(int[] nums) {
     Arrays.sort(nums);
     result = new ArrayList<>();

     for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
 
        if (i == 0 || nums[i] != nums[i-1]) {
            twoSum(i, nums);
        }
     }

     return result;
    }

    private void twoSum(int idx, int[] nums) {
        int i = idx + 1;
        int j = nums.length - 1;

        while (i < j) {

            int curr = nums[idx] + nums[i] + nums[j];

            if (curr < 0) {
                ++i;
            } else if (curr > 0) {
                --j; 
            } else {
                result.add(Arrays.asList(nums[idx], nums[i++], nums[j--]));
                while (i < j && nums[i] == nums[i-1]) {
                    ++i;
                }
            }
        }
    }
}