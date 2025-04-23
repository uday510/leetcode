class Solution {
    Set<String> words;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        words = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        int level = 0;

        if (!words.contains(endWord)) return level;

        queue.offer(beginWord);
        words.remove(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            level++;
            for (int i = 0; i < size; ++i) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;
                var neighbors = getNeighbors(word);
                for (var neighbor : neighbors) {
                    queue.offer(neighbor);
                }
            }

        }

        return 0;
    }

    private List<String> getNeighbors(String word) {
        char[] chars = word.toCharArray();
        List<String> list = new ArrayList<>();

        for (int idx = 0; idx < chars.length; ++idx) {
            char temp = chars[idx];
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (ch == temp) continue;

                chars[idx] = ch;
                String str = new String(chars);

                if (!words.contains(str)) continue;

                list.add(str);
                words.remove(str);
            }

            chars[idx] = temp;
        }
        return list;
    }
}