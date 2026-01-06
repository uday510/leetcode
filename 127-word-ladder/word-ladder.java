class Solution {

    public int ladderLength(String st, String en, List<String> words) {
        Set<String> wList = new HashSet<>(words);

        if (!wList.contains(en)) return 0;

        wList.remove(st);

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(st);

        int level = 1, sz;

        while (!queue.isEmpty()) {
            level++;

            sz = queue.size();

            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();

                List<String> neighbors = getNeighbors(cur, wList);

                for (String nei : neighbors) {

                    if (nei.equals(en)) {
                        return level;
                    }

                    queue.offer(nei);
                }
            }

        }

        return 0;
    }

    private List<String> getNeighbors(String s, Set<String> validWords) {

        char[] chars = s.toCharArray();
        List<String> neighbors = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char or = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == or) continue;  

                chars[i] = c;

                String cur = new String(chars);

                if (!validWords.contains(cur)) continue;

                validWords.remove(cur);
                neighbors.add(cur); 
            }

            chars[i] = or;
        }

        return neighbors;
    }

}