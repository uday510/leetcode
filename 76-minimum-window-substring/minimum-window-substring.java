class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int st = -1, min = n + 1, cnt = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

        for (int l = 0, r = 0; r < n; r++) {
            char c2 = s.charAt(r); 
            if (map.containsKey(c2)) {
                map.put(c2, map.get(c2) - 1);
                if (map.get(c2) >= 0) cnt++;
            }

            while (cnt == m) {
                if (r - l + 1 < min) {
                    st = l;
                    min = r - l + 1;
                }

                char c1 = s.charAt(l);
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) + 1);
                    if (map.get(c1) > 0) cnt--;
                }
                l++;
            }
        }

        return st == -1 ? "" : s.substring(st, st + min);
    }
}