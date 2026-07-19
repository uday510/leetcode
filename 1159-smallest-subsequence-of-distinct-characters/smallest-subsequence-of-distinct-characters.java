class Solution {
    public String smallestSubsequence(String s) {
        
        int[] lastPos = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            lastPos[c - 'a'] = i;
        }

        boolean[] inSt = new boolean[26];
        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (inSt[c - 'a']) continue;
            while (!st.isEmpty() &&
             st.peek() > c &&
             lastPos[st.peek() - 'a'] > i
             ) {
                inSt[st.pop() - 'a'] = false;
             }

             inSt[c - 'a'] = true;
             st.push(c);
        }

        StringBuilder sb = new StringBuilder();

        for (var it = st.descendingIterator(); it.hasNext();) {
            sb.append(it.next());
        }

        return sb.toString();
    }
}