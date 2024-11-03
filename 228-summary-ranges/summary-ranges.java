class Solution {
    public List<String> summaryRanges(int[] nums) {
        int N = nums.length;
        var ans = new ArrayList<String>();

        for (int i = 0; i < N; ++i) {
            int curr = nums[i];

            while (i < N-1 && nums[i]+1 == nums[i+1]) i++;

            if (curr != nums[i])
                ans.add(curr + "->" + nums[i]);
            else 
                ans.add(curr + "");
        }
        return ans;
    }
}