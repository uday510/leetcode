class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) return 0;

        queue.offer(beginWord);
        words.remove(beginWord);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int idx = 0; idx < size; ++idx) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }

                List<String> neighbors = getNeighbors(word, words);
                for (String neighbor : neighbors) {

                    if (words.contains(neighbor)) {
                        queue.offer(neighbor);
                        words.remove(neighbor);
                    }
                }
            }
        }

        return 0;
    }

    private List<String> getNeighbors(String word, Set<String> words) {
        List<String> neighbors = new ArrayList<>();

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];

           for (char j = 'a'; j <= 'z'; j++) {
               if (original == j) continue;
               chars[i] = j;
               String newWord = new String(chars);
               if (words.contains(newWord))
                   neighbors.add(newWord);
           }

           chars[i] = original;
        }

        return neighbors;
    }
}