class Solution {
    public int longestConsecutive(int[] nums) {
        var seen = new HashSet<Integer>();
        int longest = 0;

        for (int num : nums) seen.add(num);

        for (int num : nums) {
            if (seen.contains(num-1)) continue;

            int streak = 0;
            int curr = num;

            while (seen.contains(curr)) {
                ++streak;
                ++curr;
            }
            longest = Math.max(longest, streak);
        }
        return longest;
    }
}