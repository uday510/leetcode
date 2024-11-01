class Solution {
    public boolean isSubsequence(String s, String t) {
       int ptr = 0; int i = 0; int M = s.length(); int N = t.length();

       while (i < N && ptr < M) {
            if (s.charAt(ptr) == t.charAt(i))
                ++ptr;
            ++i;
       } 
       return ptr == M; 
    }
}