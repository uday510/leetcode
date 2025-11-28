class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;

        for (int num : set) {

            if (set.contains(num - 1)) continue;

            int cur = 1;

            while (set.contains(num + 1)) {
                num++;
                cur++;
            }

            longest = Math.max(longest, cur);
        }

        return longest;
    }
}