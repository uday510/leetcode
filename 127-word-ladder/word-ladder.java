class Solution {
    public int ladderLength(String st, String en, List<String> words) {
        
        if (st.equals(en)) 
            return 0;
        
        Set<String> validWords = new HashSet<>(words);

        if (!validWords.contains(en))
            return 0;

        int len = 1;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(st);
        validWords.remove(st);

        while (!queue.isEmpty()) {
            len++;

            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        
                        chars[j] = c;
                        String str = new String(chars);

                        if (!validWords.contains(str))
                            continue;

                        if (str.equals(en))
                            return len;
                        
                        validWords.remove(str);
                        queue.offer(str);
                    }

                    chars[j] = old;
                }
            }
        }

        return 0;
    }
}