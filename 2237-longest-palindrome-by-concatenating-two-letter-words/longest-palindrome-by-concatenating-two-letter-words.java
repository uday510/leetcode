class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (var s : words) {
            map.merge(s, 1, Integer::sum);
        }

        Set<String> seen = new HashSet<>();
        boolean hasCenter = false;
        int longest = 0;
        for (var s : words) {
            String rev = new StringBuilder(s).reverse().toString();
            if (s.charAt(0) == s.charAt(1) && map.containsKey(s)) {
                int count = map.get(s);
                longest += (count / 2) * 4;
                if (count % 2 == 1) {
                    hasCenter = true;
                }
                map.remove(s);
            }  else if (map.containsKey(rev) && map.containsKey(s)) {
                int min = Math.min(map.get(rev), map.get(s));
                longest = Math.max(longest, longest + 4 * min);
                map.remove(rev);
                map.remove(s);
            }
        }

        if (hasCenter) longest += 2;
        return longest;
    }
}
