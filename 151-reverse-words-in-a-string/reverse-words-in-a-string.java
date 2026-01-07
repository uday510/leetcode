class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trim(s);

        reverse(0, sb.length() - 1, sb);
        reverseEachWord(sb);

        return sb.toString();
    }

    private StringBuilder trim(String s) {
        StringBuilder sb = new StringBuilder();

        int i = 0, j = s.length() - 1;

        while (i < j && s.charAt(i) == ' ') i++;
        while (i < j && s.charAt(j) == ' ') j--;

        while (i <= j) {
            char ch = s.charAt(i);

            if (ch != ' ') sb.append(ch);
            else if (sb.charAt(sb.length() - 1) != ' ') sb.append(ch);

            i++; 
        }

        return sb;
    }

    private void reverseEachWord(StringBuilder sb) {
        int i = 0, j = 0, n = sb.length();

        while (i < n) {
            j = i;
            while (j < n && sb.charAt(j) != ' ') j++;

            reverse(i, j - 1, sb);

            i = j + 1;
        }
        
    }

    private void reverse(int i, int j, StringBuilder sb) {
        while (i < j) swap(i++, j--, sb);
    }

    private void swap(int i, int j, StringBuilder sb) {
        char tmp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, tmp);
    }

}