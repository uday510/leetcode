class Solution {
    public int strStr(String haystack, String needle) {
        
        for (int idx = 0; idx < haystack.length(); ++idx) {
            int prev = idx;
            int index = 0;

            while (idx < haystack.length() && index < needle.length()) {
                if (haystack.charAt(idx) == needle.charAt(index)) {
                    System.out.println(idx + " " + index);
                    idx++;
                    index++;
                } else {
                    System.out.println("-------");
                    break;
                }
            }

            if (index == needle.length()) return prev;
            idx = prev;
        }

        return -1;
    }
}