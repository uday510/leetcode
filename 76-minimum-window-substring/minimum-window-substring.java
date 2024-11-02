class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int N = s.length();
        int M = t.length();
        int startIdx = 0;
        int endIdx = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int cnt = 0;

        for (char c : t.toCharArray()) 
            map[c]++;
        
        while (endIdx < N) {
            char endChar = s.charAt(endIdx);
            if (map[endChar] > 0)   
                ++cnt;
            map[endChar]--;
            ++endIdx;
            while (cnt == M) {
                if (endIdx - startIdx < minLen) {
                    minStart = startIdx;
                    minLen = endIdx - startIdx;
                }
                char startChar = s.charAt(startIdx);

                map[startChar]++;

                if (map[startChar] > 0) --cnt;

                ++startIdx;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}