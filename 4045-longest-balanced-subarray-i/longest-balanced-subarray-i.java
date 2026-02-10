class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length, longest = 0;
        Set<Integer> even = new HashSet<>();
        Set<Integer> odd = new HashSet<>();

        for (int i = 0; i < n; i++) {
           even.clear();
           odd.clear();

            for (int j = i; j < n; j++) {
                if ((nums[j] & 1 ) == 1) odd.add(nums[j]);
                else even.add(nums[j]);

                longest = even.size() == odd.size() ? 
                            Math.max(longest, j - i + 1) : 
                            longest;

            }

        }

        return longest;
    }
}