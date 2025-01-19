class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = trim(s);

        reverse(0, stringBuilder.length() - 1, stringBuilder);
        reverseEachWord(stringBuilder);

        return stringBuilder.toString();
    }

    private StringBuilder trim(String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();

        while (leftIdx < rightIdx && str.charAt(leftIdx) == ' ') ++leftIdx;
        while (leftIdx < rightIdx && str.charAt(rightIdx) == ' ') --rightIdx;

        while (leftIdx <= rightIdx) {
            char ch = str.charAt(leftIdx);

            if (ch != ' ') {
                stringBuilder.append(ch);
            } else if (stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
                stringBuilder.append(ch);
            }

            leftIdx++;
        }

        return stringBuilder;
    }

    private void reverse(int leftIdx, int rightIdx, StringBuilder stringBuilder) {

        while (leftIdx < rightIdx) {
            char temp = stringBuilder.charAt(leftIdx);
            stringBuilder.setCharAt(leftIdx++, stringBuilder.charAt(rightIdx));
            stringBuilder.setCharAt(rightIdx--, temp);
        }

    }

    private void reverseEachWord(StringBuilder stringBuilder) {

        int leftIdx = 0;
        int rightIdx = 0;
        int length = stringBuilder.length();

        while (leftIdx < length) {

            while (rightIdx < length && stringBuilder.charAt(rightIdx) != ' ') {  
                rightIdx++;
            }

            reverse(leftIdx, rightIdx - 1, stringBuilder);

            leftIdx = rightIdx + 1;
            rightIdx += 1;
        }
    }


}