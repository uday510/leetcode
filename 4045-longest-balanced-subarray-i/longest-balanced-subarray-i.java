class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length, longest = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            for (int j = i; j < n; j++) {
                if ((nums[j] & 1 ) == 1) odd.add(nums[j]);
                else even.add(nums[j]);

                if (even.size() == odd.size()) {
                    longest = Math.max(longest, j - i + 1);
                }

            }

        }

        return longest;
    }
}