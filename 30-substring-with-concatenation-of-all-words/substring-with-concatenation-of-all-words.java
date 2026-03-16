class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        int n = s.length();
        int w = words[0].length();
        List<Integer> res = new ArrayList<>();
        int m = words.length;

        Map<String, Integer> cnts = new HashMap<>();
        for (String word : words) cnts.merge(word, 1, Integer::sum);

        Map<String, Integer> cur = new HashMap<>();
        for (int i = 0; i < w; i++) {
            cur.clear();
            int l = i, r = i;
            int cnt = 0;

            while (r + w <= n) {
                String sub = s.substring(r, r + w);
                r += w;

                if (!cnts.containsKey(sub)) {
                    cnt = 0;
                    cur.clear();
                    l = r;
                } else {
                    cur.merge(sub, 1, Integer::sum);
                    cnt++;

                    while (cur.get(sub) > cnts.get(sub)) {
                        cur.merge(s.substring(l, l + w), -1, Integer::sum);

                        l += w;
                        --cnt;
                    }

                    if (cnt == m) res.add(l);
                }
            }
        }

        return res;
    }
}