class Solution {
    public int strStr(String haystack, String needle) {
        int idx = 0;

        while (idx < haystack.length()) {

            int index = 0;

            while ((index + idx) < haystack.length() && index < needle.length()) {
                if (haystack.charAt(index + idx) == needle.charAt(index)) {
                    index++;
                } else {
                    break;
                }
            }
            if (index == needle.length()) return idx;

            ++idx;
        }
        return -1;
    }
}