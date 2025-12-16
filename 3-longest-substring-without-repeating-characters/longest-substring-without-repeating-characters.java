class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int longest = 0;

        Map<Character, Integer> map;

        for (int i = 0; i < n; i++) {
            map = new HashMap<>();

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                map.merge(ch, 1, Integer::sum);
                
                if (map.get(ch) > 1) break;

                longest = Math.max(longest, j - i + 1);

            }
        }

        return longest;
    }
}