class Solution {
    public String reverseWords(String s) {
        StringBuilder sb =  trim(s);

        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);

        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int i = 0, j = n - 1;

        while (i < n) {
            j = i;

            while (j < n && sb.charAt(j) != ' ') j++;

            reverse(sb, i, j - 1);

            i = j + 1;
        }
    }

    private void reverse(StringBuilder sb, int i, int j) {

        while (i < j) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
            i++; j--;
        }
    }

    private StringBuilder trim(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != ' ') sb.append(c);
            else if (sb.charAt(sb.length() - 1) != ' ') sb.append(c);
        }

        return sb;
    }
}