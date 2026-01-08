class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        int n = s.length();
        int window = words[0].length();
        List<Integer> res = new ArrayList<>();
        int m = words.length;

        Map<String, Integer> wCntMap = new HashMap<>();
        for (String w : words) wCntMap.put(w, wCntMap.getOrDefault(w, 0) + 1);

        Map<String, Integer> curCntMap = new HashMap<>();
        for (int i = 0; i < window; i++) {
            curCntMap.clear();
            int l = i, r = i;
            int curCnt = 0;

            while (r + window <= n) {
                String curStr = s.substring(r, r + window);
                r += window;

                if (!wCntMap.containsKey(curStr)) {
                    curCnt = 0;
                    curCntMap.clear();
                    l = r;
                } else {
                    curCntMap.put(curStr, curCntMap.getOrDefault(curStr, 0) + 1);
                    ++curCnt;

                    while (curCntMap.get(curStr) > wCntMap.get(curStr)) {
                        String lStr = s.substring(l, l + window);

                        curCntMap.put(lStr, curCntMap.getOrDefault(lStr, 0) - 1);

                        l += window;
                        --curCnt;
                    }

                    if (curCnt == m) res.add(l);
                }
            }

        }

        return res;
    }
}