class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        
        Arrays.sort(nums);

        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1, right = n - 1;

            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];

                if (currSum < 0) left++;
                else if (currSum > 0) right--;
                else {

                    list.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < n && nums[left] == nums[left-1]) left++;

                    while (right > -1 && nums[right] == nums[right + 1]) right--;
                }
            }
        }

        return list;
    }
}