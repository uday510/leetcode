class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs[0].length();

        for (int i = 0; i < n; i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}