class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) 
            return 0;
        int end = needle.length();

        for (int i = 0; i < haystack.length()-end+1; ++i) {
            String curr = haystack.substring(i, i+end);
            System.out.println(curr);
            if (curr.equals(needle))
                return i;
        }
        return -1;
    }
}