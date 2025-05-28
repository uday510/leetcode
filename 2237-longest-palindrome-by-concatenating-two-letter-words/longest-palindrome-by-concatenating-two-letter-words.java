class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (var s : words) {
            map.merge(s, 1, Integer::sum);
        }

        boolean flag = false;
        int longest = 0;
        
        for (var s : words) {
            if (!map.containsKey(s)) continue;
            String rev = new StringBuilder(s).reverse().toString();
            if (s.charAt(0) == s.charAt(1)) {
                int count = map.get(s);
                longest += (count / 2) * 4;
                if (count % 2 == 1) {
                    flag = true;
                }
                map.remove(s);
            }  else if (map.containsKey(rev)) {
                int min = Math.min(map.get(rev), map.get(s));
                longest = Math.max(longest, longest + 4 * min);
                map.remove(rev);
                map.remove(s);
            }
        }

        return flag ? longest + 2 : longest;
    }
}
