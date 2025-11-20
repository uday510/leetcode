class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;

        for (int num : nums) set.add(num);

        for (int num : set) {
            if (set.contains(num - 1)) continue;

            int cnt = 0, cur = num;
            while (set.contains(cur)) {
                cnt++; cur++;
            }

            longest = Math.max(longest, cnt);
        }

        return longest;
    }
}