class Solution {

    Set<String> validWords;

    public int ladderLength(String st, String en, List<String> wordList) {
        validWords = new HashSet<>(wordList);

        if (!validWords.contains(en)) return 0;

        if (st.equals(en)) return 0;

        int len = 1;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(st);
        validWords.remove(st);

        while (!queue.isEmpty()) {
            int sz = queue.size();

            len++;
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                List<String> neighbors = getNeighbors(cur);

                for (String nei : neighbors) {
                    if (nei.equals(en)) return len;
                    queue.offer(nei);
                }
            }
        }

        return 0;
    }

    private List<String> getNeighbors(String s) {
        char[] chars = s.toCharArray();
        List<String> neighbors = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (originalChar == c) continue;

                chars[i] = c;
                String nei = new String(chars);

                if (!validWords.contains(nei)) continue;

                validWords.remove(nei);
                neighbors.add(nei);
            } 

            chars[i] = originalChar;
        }

        return neighbors;
    }
}