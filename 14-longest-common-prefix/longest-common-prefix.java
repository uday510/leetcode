class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String fst = strs[0];

        for (int i = 0; i < fst.length(); i++) {
            char c = fst.charAt(i);

            for (int j = 1; j < n; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != fst.charAt(i)) {
                    return fst.substring(0, i);
                }
            }
        }

        return fst;
    }
}