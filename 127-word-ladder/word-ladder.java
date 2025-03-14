class Solution {
    Set<String> words;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        words = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        int level = 1;

        words.remove(beginWord);
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int idx = 0; idx < size; ++idx) {
                String str = queue.poll();
                List<String> neighbors = getNeighbors(str);
                System.out.println(str + " " + neighbors);

                for (String neighbor : neighbors) {
                    if (neighbor.equals(endWord)) {
                        return level;
                    }
                    queue.offer(neighbor);
                }
            }
        }
        return 0;
    }

    private List<String> getNeighbors(String str) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = str.toCharArray();

        for (int idx = 0; idx < chars.length; ++idx) {

            char originalChar = chars[idx];

            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (ch == originalChar) continue;

                chars[idx] = ch;
                String neighbor = new String(chars);
                if (words.contains(neighbor)) {
                    neighbors.add(neighbor);
                    words.remove(neighbor);
                }
            }

            chars[idx] = originalChar;
        }

        return neighbors;
    }
}