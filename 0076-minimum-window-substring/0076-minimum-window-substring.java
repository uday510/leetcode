class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        if (m < n) return "";
        
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            char c = t.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        int start = 0;
        int total = 0;
        int currLen = 0;
        for (int head = 0, tail = 0; tail < m; ++tail) {
            char tailChar = s.charAt(tail);

            if (!hm.containsKey(tailChar)) continue;
            hm.put(tailChar, hm.get(tailChar)-1);
            if (hm.get(tailChar) >= 0) ++total;

           if (total == n) {

                while (hm.get(s.charAt(head)) == null || hm.get(s.charAt(head)) <  0) {
                        if (hm.get(s.charAt(head)) != null)
                            hm.put(s.charAt(head), hm.get(s.charAt(head))+1);
                        ++head;
                }

                 if (currLen == 0 || tail - head < currLen) {
                        currLen = tail - head + 1;
                        start = head;
                }
           }
        }

        return s.substring(start, start+currLen);
    }

}