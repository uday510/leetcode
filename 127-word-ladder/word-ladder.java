class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        queue.add(beginWord);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ++level;
            for (int i = 0; i < size; ++i) {
                String s = queue.poll();
                if (s.equals(endWord)) return level;
                List<String> neighbors = getNeighbors(s);
                for (String nei : neighbors) {
                    if (set.contains(nei)) {
                        set.remove(nei);
                        queue.offer(nei);
                    }
                }
            }
        }
        return 0;
    }
    public List<String> getNeighbors(String s) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < chars.length; ++i) {
            char tmp = chars[i];
            for (char c = 'a'; c <= 'z'; ++c) {
                chars[i] = c;
                String nei = new String(chars);
                list.add(nei);
            }
            chars[i] = tmp;
        }
        return list;
    }
}