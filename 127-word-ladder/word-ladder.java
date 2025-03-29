class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 0;
        Queue<String> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>(wordList);

        if (!seen.contains(endWord)) return 0;

        seen.remove(beginWord);
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            for (int idx = 0; idx < size; ++idx) {
                String str = queue.poll();
                if (str.equals(endWord)) return level;
                List<String> neighbors = getNeighbors(str, seen);
                for (String nei : neighbors) {
                    queue.offer(nei);
                }
            }

        }
        return 0;
    }

    private List<String> getNeighbors(String str, Set<String> seen) {
        List<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();

        for (int idx = 0; idx < chars.length; ++idx) {
            char tmp = chars[idx];

            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (ch == tmp) continue;
                chars[idx] = ch;
                String curr = String.valueOf(chars);

                if (seen.contains(curr)) {
                    list.add(curr);
                    seen.remove(curr);
                }
            }
            chars[idx] = tmp;
        }

        return list;
    }
}