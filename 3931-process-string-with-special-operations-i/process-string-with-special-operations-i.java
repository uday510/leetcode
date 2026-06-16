class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            

            if ((c >= 'a' && c <= 'z')) sb.append(c);

            if (c == '#') sb.append(sb);
            if (c == '%') sb.reverse();
            if (c == '*' && !sb.isEmpty()) sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}