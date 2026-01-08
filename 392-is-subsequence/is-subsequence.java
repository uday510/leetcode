class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0, sLen = s.length(), tLen = t.length();

        for (int tIdx = 0; sIdx < sLen && tIdx < tLen; tIdx++) {

            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
            }
            
        }

        return sIdx == sLen;
    }
}