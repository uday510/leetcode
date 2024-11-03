import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        int longest = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currStreak = 0;

                while (set.contains(currNum)) {
                    currNum++;
                    currStreak++;
                }

                longest = Math.max(longest, currStreak);
            }
        }

        return longest;
    }
}
