class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        int N = nums.length;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int cur = nums[i];

            while (i < N - 1 && nums[i] + 1 == nums[i + 1]) i++;

            if (cur != nums[i]) res.add(cur + "->"  + nums[i]);
            else res.add(cur + "");
        }

        return res;
    }
}