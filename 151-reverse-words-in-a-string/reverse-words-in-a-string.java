class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trim(s);

        reverse(sb, 0, sb.length() - 1);

        reverseEachWord(sb);

        return sb.toString();
    }
    private StringBuilder trim(String s) {
        int leftIdx = 0;
        int rightIdx = s.length() - 1;

        while (leftIdx <= rightIdx && s.charAt(leftIdx) == ' ') ++leftIdx;

        while (leftIdx <= rightIdx && s.charAt(rightIdx) == ' ') --rightIdx;

        StringBuilder sb = new StringBuilder();

        while (leftIdx <= rightIdx) {
            char curr = s.charAt(leftIdx);

           if (curr != ' ') sb.append(curr);
           else if (sb.charAt(sb.length()-1)!= ' ')
                sb.append(curr);
            ++leftIdx;
        }
        return sb;
    }
    private void reverse(StringBuilder sb, int leftIdx, int rightIdx) {
        while (leftIdx < rightIdx) {
            char tmp = sb.charAt(leftIdx);
            sb.setCharAt(leftIdx++, sb.charAt(rightIdx));
            sb.setCharAt(rightIdx--, tmp);
        }
    }
    private void reverseEachWord(StringBuilder sb) {
        int N = sb.length();
        int leftIdx = 0;
        int rightIdx = 0;

        while (rightIdx < N) {
            while (rightIdx < N && sb.charAt(rightIdx) != ' ') 
                ++rightIdx;

            reverse(sb, leftIdx, rightIdx-1);
            leftIdx = rightIdx + 1;
            ++rightIdx;
        }
    }
}