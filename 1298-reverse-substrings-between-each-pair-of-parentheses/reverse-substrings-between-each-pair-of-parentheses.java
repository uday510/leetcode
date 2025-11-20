class Solution {
    public String reverseParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') st.push(sb.length());
            else if (ch == ')') reverse(st.pop(), sb.length() - 1, sb);
            else sb.append(ch);
        }

        return sb.toString();
    }

    private void reverse(int i, int j, StringBuilder sb) {

        while (i < j) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i++, sb.charAt(j));
            sb.setCharAt(j--, tmp);
        }
    }
}