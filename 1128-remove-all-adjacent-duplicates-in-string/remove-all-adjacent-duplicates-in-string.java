class Solution {
    public String removeDuplicates(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && st.peekLast() == ch) {
                st.pollLast();
            } else st.offerLast(ch);
        }

       StringBuilder sb = new StringBuilder();
       for (char c : st) sb.append(c);
       
       return sb.toString();
    }
}