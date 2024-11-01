class Solution {
    public int strStr(String haystack, String needle) {
        int N = haystack.length();
        int M = needle.length();
        for (int start = 0; start < N-M+1; ++start) {
            int idx = 0;
            for (; idx < M; ++idx) {
                if (needle.charAt(idx) != haystack.charAt(start+idx)) 
                    break;
            }
            if (idx == M)
                return start;
        }
        return -1;
    }
}