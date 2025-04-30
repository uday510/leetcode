class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int idx1 = 0, idx2 = 0;

        while (idx1 < word1.length() && idx2 < word2.length()) {
            stringBuilder.append(word1.charAt(idx1++));
            stringBuilder.append(word2.charAt(idx2++));
        }

        addRemainingChars(idx1, word1, stringBuilder);
        addRemainingChars(idx2, word2, stringBuilder);

        return stringBuilder.toString();
    }
    private void addRemainingChars(int idx, String str, StringBuilder sb) {

        while (idx < str.length()) sb.append(str.charAt(idx++));
    }
}