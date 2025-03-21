class Solution {
    public String mergeAlternately(String word1, String word2) {
         int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder stringBuilder = new StringBuilder();

        for (int idx = 0; idx < Math.max(len1, len2); ++idx) {

            if (idx < len1) {
                stringBuilder.append(word1.charAt(idx));
            }

            if (idx < len2) {
                stringBuilder.append(word2.charAt(idx));
            }
        }

        return stringBuilder.toString();
    }
}