class Solution {
    public String smallestSubsequence(String s) {
        
        int[] pos = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            pos[c - 'a'] = i;
        }

        Deque<Character> st = new ArrayDeque<>();
        boolean[] inSt = new boolean[26];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (inSt[c - 'a']) continue;

            while (!st.isEmpty() && st.peek() > c && 
            pos[st.peek() - 'a'] > i ) {
                inSt[st.pop() - 'a'] = false;
            }

            inSt[c - 'a'] = true;
            st.push(c);
        } 

        StringBuilder sb = new StringBuilder();

        for (Iterator<Character> it = st.descendingIterator(); it.hasNext();) {
            sb.append(it.next());
        }

        return sb.toString();
    }
}