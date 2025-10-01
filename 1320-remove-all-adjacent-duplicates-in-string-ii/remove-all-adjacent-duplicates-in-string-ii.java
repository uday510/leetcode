class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Pair> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (st.isEmpty()) {
                st.offerLast(new Pair(ch));
            } else {
                if (st.peekLast().ch == ch) {
                    st.peekLast().cnt += 1; 
                    if (st.peekLast().cnt == k) st.pollLast();
                } else {
                    st.offerLast(new Pair(ch));
                }
            } 
        }

        StringBuilder sb = new StringBuilder();

        for (Pair p : st) {
            for (int i = 0; i < p.cnt; i++) 
                sb.append(p.ch);
        }

        return sb.toString();
    }
}

class Pair {
    char ch;
    int cnt;
    Pair(char ch) {
        this.ch = ch;
        cnt = 1;
    }
}