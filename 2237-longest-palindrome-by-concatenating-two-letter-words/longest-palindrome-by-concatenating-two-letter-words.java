class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (var s : words) {
            map.merge(s, 1, Integer::sum);
        }

        Set<String> seen = new HashSet<>();
        boolean flag = false;

        List<String> list = new ArrayList<>();
        for (var k : map.keySet()) {
            if (map.get(k) == 1 && k.charAt(0) == k.charAt(1)) list.add(k);
        };

        if (list.size() == words.length) return 2;

        System.out.println(map);

        for (int i = 0; i < list.size() - 1; ++i) {
            map.remove(list.get(i));
            list.remove(i);
        }

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

/**

lc - 1
cl - 1
gg - 1


ty ty ty yt yt

ty yt ty yt
 */