class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int len = s.length();
        
        while (j < len) {
            map.merge(s.charAt(j), 1, Integer::sum);

            while (i < j && map.get(s.charAt(j)) > 1) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }

            int current = (j - i + 1);
            longest = Math.max(longest, current);
            j++;
        }

        return longest;
    }
}