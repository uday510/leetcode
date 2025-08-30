class Solution {
    public String toLowerCase(String s) {
       StringBuilder sb = new StringBuilder();
       int n = s.length();

       for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                sb.append((char) (ch - 'A' + 'a'));
            } else {
                sb.append(ch);
            }
       }

       return sb.toString();
    }
}