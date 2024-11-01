class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int N = nums.length;
        var ans = new ArrayList<List<Integer>>();

        for (int i = 0; i < N-2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) 
                continue;
            int j = i+1;
            int k = N-1;
            while (j < k) {
                if (k < N-1 &&nums[k] == nums[k+1]) {
                    k--;
                    continue;
                }
                int curr = nums[i] + nums[j] + nums[k];

                if (curr == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    ++j;
                    --k;
                } else if (curr < 0)
                    ++j;
                    else --k;
            }
        }
        return ans;
    }
}