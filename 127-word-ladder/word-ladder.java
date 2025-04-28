class Solution {
    Set<String> words;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        words = new HashSet<>(wordList);
        wordList.remove(beginWord);

        if (!words.contains(endWord)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        int level = 1;
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int pos = 0; pos < size; ++pos) {
                String currentString = queue.poll();

                List<String> neighbors = getNeighbors(currentString);

                for (String neighbor : neighbors) {
                    if (neighbor.equals(endWord)) return level;
                    queue.offer(neighbor);
                }
            }
        }

        return 0;
    }

    private List<String> getNeighbors(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        List<String> neighbors = new ArrayList<>();

        for (int idx = 0; idx < stringBuilder.length(); ++idx) {
            char originalCharacter = stringBuilder.charAt(idx);

            for (char ch = 'a'; ch <= 'z'; ++ch) {
                stringBuilder.setCharAt(idx, ch);
                String formedString = stringBuilder.toString();
                if (!words.contains(formedString)) continue;
                words.remove(formedString);
                neighbors.add(formedString);
            }

            stringBuilder.setCharAt(idx, originalCharacter);
        }

        return neighbors;
    }
}