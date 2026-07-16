class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord))
            return 0;

        Set<String> validWords = new HashSet<>(wordList);

        if (!validWords.contains(endWord))
            return 0;

        Queue<String> queue = new ArrayDeque<>();
        validWords.remove(beginWord);
        queue.offer(beginWord);

        int ladderLength = 0;
        while (!queue.isEmpty()) {
            ladderLength++;

            int sz = queue.size();
            
            for (int i = 0; i < sz; i++) {
                char[] chars = Objects.requireNonNull(queue.poll()).toCharArray();
                for (int idx = 0; idx < chars.length; idx++) {

                    char old = chars[idx];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[idx] = c;
                        String s = new String(chars);
                        
                        if (!validWords.contains(s))
                            continue;
                        
                        if (s.equals(endWord))
                            return ladderLength + 1;

                        validWords.remove(s);
                        queue.offer(s);
                    }
                    chars[idx] = old;
                }
            }
        }
        return 0;
    }
}