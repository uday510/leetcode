class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) set.add(num);

        int longest = 0;

        for (int cur : set) {
            if (set.contains(cur - 1)) continue;

            int cnt = 0;
            while (set.contains(cur)) {
                cur++;
                cnt++;
            }

            longest = Math.max(longest, cnt);
        }

        return longest;
    }
}