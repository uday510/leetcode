class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        list = new ArrayList<>();
        int target = 0;
       
        for (int idx = 0; idx < nums.length; ++idx) {
            if (idx > 0 && nums[idx] == nums[idx - 1]) continue;
            int leftIdx = idx + 1;
            int rightIdx = nums.length - 1;

            while (leftIdx < rightIdx) {
                int sum = nums[idx] + nums[leftIdx] + nums[rightIdx];

                if (sum < target) leftIdx++;
                else if (sum > target) rightIdx--;
                else {
                    list.add(new ArrayList<>(Arrays.asList(nums[idx], nums[leftIdx], nums[rightIdx])));
                    leftIdx++;
                    rightIdx--;
                    while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx - 1]) leftIdx++;
                    while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx + 1]) rightIdx--;
                }
            }
        }

        return list;
    }
}