class Solution {
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Pair> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!st.isEmpty()) {
                if (ch == st.peekLast().ch){
                    if (st.peekLast().cnt + 1 >= k) st.pollLast();
                    else st.peekLast().cnt++;
                } else st.offerLast(new Pair(ch));
            } else {
                st.offerLast(new Pair(ch));
            } 
        }

        StringBuilder sb = new StringBuilder();

        for (Pair p : st) {
            for (int i = 0; i < p.cnt; i++) sb.append(p.ch);
        }

        return sb.toString();
    }

    private class Pair {
        char ch;
        int cnt;
        Pair(char ch) {
            this.ch = ch;
            cnt = 1;
        }
    }

}