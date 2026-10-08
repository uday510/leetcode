class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int st = 0, open = 0, closed = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') open++;
            else closed++;


            if (open == closed) {
                sb.append(s.substring(st + 1, i));
                st = i + 1;
            }
        }

        return sb.toString();
    }
}