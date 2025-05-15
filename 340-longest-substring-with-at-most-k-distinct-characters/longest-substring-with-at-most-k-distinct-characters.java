class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0, n = s.length(), i = 0;

        for (int j = 0; j < n; ++j) {
            map.merge(s.charAt(j), 1, Integer::sum);

            while (i < j && map.size() > k) {
                map.merge(s.charAt(i), -1, Integer::sum);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }

            longest = Math.max(longest, j - i + 1);
        }

        return longest;
    }
}