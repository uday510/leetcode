class Solution {
    public String minWindow(String s, String t) {
        
        int m = s.length(), n = t.length(), reqChars = 0;

        Map<Character, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cntMap.put(t.charAt(i), cntMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int min = m + 1, st = -1;

        for (int l = 0, r = 0; r < m; r++) {
            
            char rChar = s.charAt(r);

            if (cntMap.containsKey(rChar)) {
                cntMap.put(rChar, cntMap.get(rChar) - 1);

                if (cntMap.get(rChar) >= 0) reqChars++;
            }

            while (l <= r && reqChars == n) {

                if (r - l + 1 < min) {
                    st = l;
                    min = r - l + 1;
                }


                char lChar = s.charAt(l);

                if (cntMap.containsKey(lChar)) {
                    cntMap.put(lChar, cntMap.get(lChar) + 1);

                    if (cntMap.get(lChar) > 0) reqChars--;
                }

                l++;

            }
        }

        return st == -1 ? "" : s.substring(st, st + min);
    }
}

/**


ZZAB CD

AB

 */