class Solution {

    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        var map = new HashMap<Character, Integer>();
        int st = 0, min = (int) 1e9;
        
        for (int i = 0; i < m; i++) map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        
        int cnt = 0;
        for (int l = 0, r = 0; r < n; r++) {
            char rightChar = s.charAt(r);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) >= 0) cnt++;
            }
            
            while (cnt == m) {     
                if (min > r - l + 1) {
                    min = r - l + 1;
                    st = l;
                }
                
                char leftChar = s.charAt(l);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) cnt--;
                }
                
                l++;
            }
        }
        
        
        return min == (int) 1e9 ? "" : s.substring(st, st + min);
    }
}